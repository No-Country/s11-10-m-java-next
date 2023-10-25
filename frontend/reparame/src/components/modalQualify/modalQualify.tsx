"use client"

import { useState } from 'react'
import StartQuatify from './startQuatify'

export default function ModalQuatify () {

    const [positionStart, setPositionStart] = useState<number>(0)

    const starts = [1, 2, 3, 4, 5]
    return (
        <div className="max-w-4xl border-2 py-2 px-5 w-full h-[602px] flex flex-col items-center border-dark-orange rounded-md">
            <h2 className='text-3xl mt-16'>Tu calificacion nos ayuda a mejorar</h2>
            <h3 className='text-2xl mt-10 font-semibold'>¿Cómo fue tu experiencia?</h3>
            <div className='flex gap-3 justify-center mt-2 max-w-xs w-full text-5xl text-orange'>
                {
                    starts.map(item => (
                        <StartQuatify key={item} position={item} positionStart={positionStart} setPositionStart={setPositionStart} />
                    ))
                }
            </div>
            <div className='flex justify-between mt-3 max-w-xs w-full'>
                <span>Muy malo</span>
                <span>Muy bueno</span>
            </div>
            <textarea className='mt-10 p-3 w-full h-44 bg-[#F5F5F5] outline-none' placeholder='Deja un comentario'></textarea>
            <div className='w-full justify-end flex gap-3 mt-5 items-center'>
                <button className='rounded-md text-base py-2 px-4'>Omitir</button>
                <button className='rounded-md text-base py-2 px-4 text-white bg-dark-orange'>Enviar</button>
            </div>
        </div>
    )
}