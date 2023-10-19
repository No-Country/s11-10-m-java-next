import React from 'react'
import Ticket from '../ticket/Ticket'
import HeaderManager from '../headerManager/HeaderManager'

const Historial = () => {
    return (
        <section className='max-w-max-view w-full'>
            <HeaderManager page='historial' />
            <Ticket />
        </section>
    )
}

export default Historial