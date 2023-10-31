'use client'
import { profesiones } from "@/utils/profesiones"
export function CardProfesiones(rubro: any) {
  return (
    <article className="flex flex-wrap flex-row gap-5 w-full">
      {profesiones.map((res: any) => (
        <button key={res.label}
          className={rubro.rubro === res.label
            ? "w-auto p-5 border-light-orange rounded-lg border-3 shadow-cardsProfesionesActive"
            : "w-auto p-5 border-grayDark rounded-lg border-3 hover:shadow-cardsProfesionesDesactive text-grayDark"}>
          <res.icon className='text-2xl' />
        </button>
      ))}
    </article>
  )
}
