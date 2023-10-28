'use client'
import { profesiones } from "@/utils/profesiones"
export function CardProfesiones() {
  return (
    profesiones.map((res: any) => (
      <button key={res.label} className="w-auto p-5 border-light-orange rounded-lg border-3">
        <res.icon className='text-2xl' />
      </button>
    ))
  )
}
