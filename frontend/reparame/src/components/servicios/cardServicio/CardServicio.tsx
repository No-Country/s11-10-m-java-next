import Link from 'next/link'
import React from 'react'


export const CardServicio = (prestador) => {
    console.log(prestador.prestador)

    return (
        <div>
            <p>name {prestador.prestador.name}</p>
            <p>email {prestador.prestador.email}</p>
            <Link href={'/routes/detalleServicio'}>ver perfil</Link>
        </div>
    )
}

