'use client'
import React from 'react'
import SearchBar from './searchBar/SearchBar'
import Image from 'next/image'
import logo from '../../../public/logo.png'
import Link from 'next/link'
import { useAppDispatch, useAppSelector } from '@/utils/globalStates/hooks'
import { verServicios } from '@/utils/globalStates/features/serviciosSlice'

const Header = () => {
    const path = useAppSelector(state => state.log.value)
    const dispatch = useAppDispatch()
    return (
        <header className='flex items-center bg-light-orange justify-center h-16 '>
            <nav className='flex flex-row justify-between gap-2 py-2 items-center max-w-max-view w-full px-10'>
                <Link href='/' onClick={() => { dispatch(verServicios('')) }}><Image src={logo} alt='' width={150} height={100} /></Link>
                {path === 'login' ? <div className='flex flex-row gap-3 mr-5'>
                    <Link href={'/routes/login'} className='text-white p-2 rounded-sm'>Iniciar sesión</Link>
                    <Link href={'/routes/registro'} className='text-dark-orange p-2 rounded-md bg-white'>Registro</Link>
                </div> :
                    <>{path === 'servicios' ? <SearchBar /> : <></>}
                        <span className='flex flex-row items-center gap-5'>
                            <Link href={'/routes/perfil'} className='min-w-avatarHeader'>
                                <Image src={'/images/Ellipse 48.png'} alt="avatar User" width={200} height={200}
                                    className='rounded-full  bg-white text-black text-xs items-center w-10 h-10' />
                            </Link>
                            <Link href={'/routes/login'} className='text-white p-2 border-2 border-white rounded-lg' onClick={() => { localStorage.setItem('tKeyId', '') }}>Log out</Link>
                        </span>
                    </>
                }
            </nav>
        </header>
    )
}

export default Header