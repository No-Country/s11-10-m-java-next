import type { Config } from "tailwindcss";
import { nextui } from "@nextui-org/react";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
    "./node_modules/@nextui-org/theme/dist/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        "mega-light-orange": "#fac79a",
        "light-orange": "#ff983f",
        "dark-orange": "#ff6600",
        red: "#fca5a5",
        red2: "#ef4444",
        orange: "#fdba74",
        grayUi: "#f5f5f5",
        'grayText': '#9ca3af'
      },
      width: {
        'inputPerfil': '600px'
      },
      maxWidth: {
        "max-view": "1520px",
        "max-textArea": "778px",
      },
      minWidth: {
        'avatarHeader': "2.5rem",
        'searchBar': "180px",
      },
      boxShadow: {
        'cardsPerfil': '2px 3px 3px 0px rgb(0 0 0 / 0.1)',
        'cardsProfesionesActive': '0px 0px 8px 0px #ff983f',
        'cardsProfesionesDesactive': '0px 0px 8px 0px #929292',
        'cardsProfesiones': '0px 0px 8px 0px #ff983f',
        'cardProfesionHome': "2px 3px 12px 0px #959393",
        'circle': "0px 4px 0px 0px #b0b0b0",
        'spanCircle': "0px 4px 5px 0px #b0b0b0"
      }
    },
  },
  darkMode: "class",
  plugins: [nextui()],
};
export default config;
