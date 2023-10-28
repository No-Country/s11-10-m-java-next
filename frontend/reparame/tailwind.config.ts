import type { Config } from 'tailwindcss'
import { nextui } from "@nextui-org/react";

const config: Config = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
    "./node_modules/@nextui-org/theme/dist/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'mega-light-orange': '#fac79a',
        'light-orange': '#ff983f',
        'dark-orange': '#ff6600',
        'red': '#fca5a5',
        'red2': '#ef4444',
        'orange': '#fdba74',
        'gray-1': '#929292',
      },
      maxWidth: {
        'max-view': '1520px',
        'max-textArea': '778px',
      },
      minWidth: {
        'avatarHeader': '2.5rem',
        'searchBar': '180px',
      },
    }
  },
  darkMode: "class",
  plugins: [nextui()],
}
export default config
