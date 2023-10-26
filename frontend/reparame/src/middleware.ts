export { default } from "next-auth/middleware";

export const config = {
  matcher: ["/routes/perfil", "/routes/servicios", "/routes/historial"],
};
