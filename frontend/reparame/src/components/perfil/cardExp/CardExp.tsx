'use client'
import { useState } from 'react'
const CardExp = () => {
    const [exp, setExp] = useState('5')
    return (
        <label className="flex flex-col bg-white gap-6 p-5 w-80 shadow-cardsPerfil rounded">
            <div className="flex flex-row gap-10 w-full justify-between">
                <small className="text-sm">Experiencia</small>
                <span className="text-sm">{exp}{' '}años</span>
            </div>
            <input type="range" min={1} max={50} value={exp} onChange={(e) => { setExp(e.target.value) }}
                className='rounded-lg h-0.5 appearance-none cursor-pointer bg-light-orange'
            />
        </label>
    )
}

export default CardExp