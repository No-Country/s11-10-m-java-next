'use client'
import React from 'react'
import { CardServicio } from './cardServicio/CardServicio'
import { useEffect, useState } from 'react'
import { getServicios } from '@/utils/requestServicios/getServicios'

const Servicios = () => {
    const [prestadores, setPrestadores] = useState([])
    useEffect(() => {
        getServicios(setPrestadores)

    }, [])
    return (
        <section className='flex flex-col max-w-max-view w-full gap-12'>
            {prestadores.map(res => (
                <CardServicio key={res.id} prestador={res} />
            ))

            }
        </section>
    )
}

export default Servicios