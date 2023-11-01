'use client'
import React from 'react'
import { CardServicio } from './cardServicio/CardServicio'
import { useEffect, useState } from 'react'
import { getServicios } from '@/utils/requestServicios/getServicios'
import DetalleServicio from './detalleServicio/DetalleServicio'
import { useAppSelector } from '@/utils/globalStates/hooks'
import HeaderManager from '../headerManager/HeaderManager'
import { useSession } from 'next-auth/react'
import Skeleton from '../loadingSpinner/Skeleton'

const Servicios = () => {
  const { data: session } = useSession()
  const [servicios, setServicios] = useState([])
  const id = useAppSelector(state => state.servicios.value)
  useEffect(() => {
    getServicios(setServicios, id, session?.user.accessToken)
  }, [id, session])
  return (
    <section className="flex flex-col max-w-max-view w-full gap-12">
      <HeaderManager page="servicios" />
      {servicios[0] || servicios.length === undefined ? (
        servicios.length > 0 ? (
          <article className="flex flex-col gap-12">
            <h1 className="text-2xl">Aca va la lista de proveedores</h1>
            {servicios.map((res: any) => (
              <CardServicio key={res.id} data={res} />
            ))}
          </article>
        ) : (
          <DetalleServicio data={servicios[0]} />
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
