'use client'
import { profesiones } from "@/utils/profesiones"
export function CardProfesiones(rubro: any) {
  return (
    <article className="flex flex-wrap flex-row gap-5 w-full">
      {profesiones.map((res: any) => (
        <button key={res.label} className={rubro.rubro === res.label ? "w-auto p-5 border-light-orange rounded-lg border-3 shadow-cardsProfesiones" : "w-auto p-5 grayUi rounded-lg border-3"}>
          <res.icon className='text-2xl' />
        </button>
      ))}
    </article>
  )
}
