import React from 'react'
import SearchBar from './searchBar/SearchBar'
import Image from 'next/image'
import logo from '../../../public/logo.png'
import Link from 'next/link'

const Header = () => {
    return (
        <header className='flex items-center bg-light-orange justify-center h-16 '>
            <nav className='flex flex-row justify-between gap-2 py-2 items-center max-w-max-view w-full px-2'>
                <Link href='/'><Image src={logo} alt='' width={150} height={100} /></Link>
                <SearchBar />
                <Link href={'/routes/perfil'} className='min-w-avatarHeader'>
                    <Image src={logo} alt='' width={10} height={10}
                        className='rounded-full  bg-white text-black text-xs items-center border-2 w-10 h-10' />
                </Link>
            </nav>
        </header>
    )
}

export default Header