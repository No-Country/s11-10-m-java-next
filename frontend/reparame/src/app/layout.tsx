
import { Providers } from '@/utils/globalStates/providers'
import './globals.css'
import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import Header from '@/components/header/Header'
import ProviderSession from '@/components/providerSession/ProviderSession'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'Reparame',
  description: 'Reparame app, software de networking entre usuarios y prestadores de servicios',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <Providers>
        <ProviderSession>
        <body className={inter.className}>
          <Header />
          <main className='bg-grayUi flex items-center justify-start flex-col min-h-screen'>
            {children}
          </main>
        </body>
        </ProviderSession>
      </Providers >
    </html>
  )
}
