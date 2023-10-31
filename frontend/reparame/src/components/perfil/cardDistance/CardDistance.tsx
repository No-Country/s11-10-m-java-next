'use client'
import { useState } from 'react'
const CardDistance = () => {
    const [distance, setDistance] = useState('30')
    return (
        <label className="flex flex-col bg-white gap-6 p-5 w-80 shadow-cardsPerfil rounded">
            <div className="flex flex-row gap-10 w-full justify-between">
                <small className="text-sm">Distancia maxima</small>
                <span className="text-sm">{distance}{' '}km.</span>
            </div>
            <input type="range" value={distance} onChange={(e) => { setDistance(e.target.value) }}
                className='rounded-lg h-0.5 appearance-none cursor-pointer bg-light-orange' />
        </label>
    )
}

export default CardDistance