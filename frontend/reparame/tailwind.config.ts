import type { Config } from 'tailwindcss'

const config: Config = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend: {
      colors: {
        'light-orange': '#ff983f',
        'dark-orange': '#ff6600',
      },
      maxWidth: {
        'max-view': '1500px',
      },
      minWidth: {
        'avatarHeader': '2.5rem',
        'searchBar': '180px'
      },
    }
  },
  plugins: [],
}
export default config
