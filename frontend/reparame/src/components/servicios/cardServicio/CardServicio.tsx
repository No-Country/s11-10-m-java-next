"use client"

import { useAppDispatch } from "@/utils/globalStates/hooks";
import Ticket from "@/components/ticket/Ticket";
import { verServicios } from "@/utils/globalStates/features/serviciosSlice";
import { BsFillStarFill } from "react-icons/bs";
import Image from "next/image";
import { useRouter } from 'next/navigation'


interface InputContainerProps {
  data?: {
    añosSector: any
    descripcion: any
    id: any
    precio: any
    prestador
    : {
      apellidoCompleto: any
      calificacion: any
      descripcion: any
      direccion: any
      id: any
      nombreCompleto: any
      numeroTelefonico: any
      username: any
      zona: any
    }
    rubro: any
  }
}
export const CardServicio: React.FC<InputContainerProps> = ({
  data
}) => {
  const dispatch = useAppDispatch();

  return (
    <div className="rounded-xl border-2 p-4 max-w-5xl m-auto border-gray-300">
      <div className="flex justify-between">
        <div className="flex gap-4">
          <Image
            src="/images/Ellipse 48.png"
            alt="avatar"
            width={100}
            height={100}
            className="w-20 h-20 rounded-full border-2 border-black"
          />
          <div className="flex flex-col justify-center gap-3">
            <div className="flex gap-3 text-dark-orange">
              <BsFillStarFill className="text-2xl" />
            </div>
            <h2>{data ? data.rubro : {}}</h2>
          </div>
        </div>
        <div>
          <button
            className="mt-3 border-b-2 border-dark-orange text-dark-orange max-h-max"
            onClick={() => {
              dispatch(verServicios(data ? data.id : {}));
            }}
          >
            ver perfil
          </button>
        </div>
      </div>
      <p>
        {data ? data.descripcion : {}}
      </p>
      <div className="flex w-full justify-between items-center mt-2">
        <p>{data ? data.prestador.direccion : {}}</p>

        <Ticket />
        {/* <Ticket servicios={servicios.servicio} /> */}
      </div>
    </div>
  );
};
