'use client'
import React from 'react'
import { CardServicio } from './cardServicio/CardServicio'
import { useEffect, useState } from 'react'
import { getServicios } from '@/utils/requestServicios/getServicios'
import DetalleServicio from './detalleServicio/DetalleServicio'
import { useAppDispatch, useAppSelector } from '@/utils/globalStates/hooks'
import HeaderManager from '../headerManager/HeaderManager'
import { useSession } from 'next-auth/react'
import Skeleton from '../loadingSpinner/Skeleton'
import { profesiones } from '@/utils/profesiones'
import { setCategory } from '@/utils/globalStates/features/categorySlice'
import { BsFilterRight } from 'react-icons/bs'
const Servicios = () => {
  const dispatch = useAppDispatch();
  const { data: session } = useSession()
  const [servicios, setServicios] = useState<any>([])
  const id = useAppSelector(state => state.servicios.value)
  const category = useAppSelector(state => state.category.value)
  useEffect(() => {
    getServicios(setServicios, id, session?.user.accessToken, category)
  }, [id, session, category])
  return (
    <section className="flex flex-col max-w-max-view w-full gap-12">
      <HeaderManager page="servicios" />
      {servicios[0] || servicios.length === undefined ? (
        servicios.length > 0 ? (
          <article className="flex flex-col gap-12">
            <h1 className="text-2xl">Búsqueda de {category === '' ? 'TODOS' : category}</h1>
            <label className='flex flex-row self-end mr-8'>
              <BsFilterRight className="h-8 w-8" />
              <select
                className='w-30'
                id="ice-cream-flavors" defaultValue={category} onChange={(e) => {
                  dispatch(setCategory(e.target.value));
                }}>
                <option >Filtrar</option>
                <option value={''} >TODOS</option>
                {profesiones.map(res => (<option value={res.label} key={res.label}>{res.label}</option>))}
              </select>
            </label>
            {servicios.map((res: any) => (
              <CardServicio key={res.id} data={res} />
            ))}
          </article>
        ) : (
          <DetalleServicio data={servicios} />
        )
      ) : (
        <>
          <Skeleton />
          <Skeleton />
          <Skeleton />
        </>
      )}
    </section>
  );
}
export default Servicios
