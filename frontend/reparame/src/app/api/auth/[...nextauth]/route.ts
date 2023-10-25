import GoogleProvider from 'next-auth/providers/google'
import CredentialsProvider from "next-auth/providers/credentials";
import NextAuth from 'next-auth/next'
import axios from 'axios'

const handler = NextAuth({
    pages: {
        signIn:'/routes/login'
    },
    providers: [
        GoogleProvider({
            clientId: process.env.GOOGLE_CLIENT_ID as string,
            clientSecret: process.env.GOOGLE_CLIENT_SECRET as string
        }),
        CredentialsProvider({
            name: 'credentials',
            credentials: {
                username: {label: 'email', type: 'email', placeholder: 'correo'},
                password: {label: 'password', type: 'password', placeholder: 'password'}
            },
            authorize: async(credentials, req) => {
                const response = await axios.post('')
                return response.data
            },
        })
    ],
    session: {
        strategy: 'jwt'
    },
    callbacks: {
        jwt: async ({token, user, account}) => {
            if(user) {
                token.sub = user.id
            }

            if(account) {
                token.accessToken = account.access_token
            }
            return token
        },
        session: async ({session, token}) => {
            if(session.user) {
                if (token.sub && token.accessToken) {
                    session.user.id = token.sub
                    session.user.accessToken = token.accessToken
                }
            }

            return session
        }
    }
})

export { handler as GET, handler as POST }