'use client'
import { useState } from 'react'
const CardExp = () => {
    const [exp, setExp] = useState('5')
    return (
        <label className="flex flex-col bg-white gap-6 p-5 w-96">
            <div className="flex flex-row gap-10 w-full justify-between">
                <small className="text-sm">Experiencia</small>
                <span className="text-sm">{exp}{' '}años</span>
            </div>
            <input type="range" value={exp} onChange={(e) => { setExp(e.target.value) }} />
        </label>
    )
}

export default CardExp