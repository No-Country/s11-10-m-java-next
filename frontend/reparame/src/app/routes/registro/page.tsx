'use client'
import Registro from '@/components/registro/Registro'
import React from 'react'

const pageRegistro = () => {
    return (
        <div className='flex flex-col items-center text-light-orange text-3xl font-bold'>
            <h1 className='mb-8'>Regístrate</h1>
            <Registro />
        </div>

    )
}

export default pageRegistro