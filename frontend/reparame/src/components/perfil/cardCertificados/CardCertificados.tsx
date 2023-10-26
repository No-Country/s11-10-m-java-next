'use client'
import { BsFillPlusSquareFill } from 'react-icons/bs'
export function CardCertificados() {
    return (
        // links.map((res: any) => (
        //     <span key={res.label} className="w-auto p-5 border-light-orange rounded-lg border-3">
        //         <res.icon className='text-2xl' />
        //     </span>
        // ))
        <span className="flex w-40 h-40 border-gray-300 rounded-lg bg-white shadow-cardsPerfil items-center justify-center">
            <button className="flex flex-col items-center text-center">
                <BsFillPlusSquareFill className='w-12 h-12 text-gray-300' />
                <small className='text-gray-300'>Subir imágenes</small>
            </button>
        </span>
    )
}
