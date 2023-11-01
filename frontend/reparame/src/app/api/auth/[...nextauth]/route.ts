import GoogleProvider from "next-auth/providers/google";
import CredentialsProvider from "next-auth/providers/credentials";
import NextAuth from "next-auth/next";
import axios from "axios";

const handler = NextAuth({
  pages: {
    signIn: "/routes/login",
  },
  providers: [
    GoogleProvider({
      clientId: process.env.GOOGLE_CLIENT_ID as string,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET as string,
    }),
    CredentialsProvider({
      name: "credentials",
      credentials: {
        username: { label: "username", type: "email", placeholder: "correo" },
        password: {
          label: "password",
          type: "password",
          placeholder: "password",
        },
      },
      authorize: async (credentials, req) => {
        const response = await axios.post(
          "https://reparame-api.onrender.com/user/login",
          { username: credentials?.username, password: credentials?.password }
        );

        if (response.status === 200) {
          return response.data;
        } else {
          return null;
        }
      },
    }),
  ],
  session: {
    strategy: "jwt",
  },
  callbacks: {
    jwt: async ({ token, user, account, session }) => {

        if(account?.provider === "credentials") {
            if(user) token.user = user, token.provider = account.provider
        }

        if(account?.provider === "google") {
                  if (user) {
                    token.sub = user.data.sub;                  
                            token.accessToken = user.data.token
                            token.provider = account.provider
                            token.id = user.data.id
                            token.email = user.data.email
                            token.photo = user.data.foto
                            token.name = user.data.name
                  }
        }
      return token
    },

    session: async ({ session, token }) => {

        if(token.provider === "credentials") {
            session.user = token.user as any
            session.user.accessToken = (token.user as any).body.token as string
        }
        if (token.provider === "google") {
            if (session.user) {
              if (token.sub && token.accessToken) {
                session.user.id = token.id as string;
                session.user.accessToken = token.accessToken;
                session.user.email = token.email
                session.user.name = token.name
                session.user.photo = token.photo as string
                session.user.sub = token.sub

              }
            }
        }
      return session;
    },
    signIn: async ({user, account }) => {
        if(account?.provider == 'google' && user) {
          try {
            const response = await axios.post('https://reparame-api.onrender.com/validarToken', {
              token: account.access_token
            })
            
            if(response.status === 200) {
              console.log(response.data)
              user.data = response.data
            } else {
                return false
            }
          } catch (error) {
            console.log(error)
          }
        }
        return true
    }
  },
});

export { handler as GET, handler as POST };