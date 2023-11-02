"use client";

import { useAppDispatch } from "@/utils/globalStates/hooks";
import Image from "next/image";
import { BsStarFill } from "react-icons/bs";
import { BsStar } from "react-icons/bs";
import ReseñaPrestador from "./reseñaPrestador/ReseñaPrestador";
import { verServicios } from "@/utils/globalStates/features/serviciosSlice";
import { profesiones } from "@/utils/profesiones";
import { CertificadoCargado } from "./cardCertificado/Certificado";
import Ticket from "@/components/ticket/Ticket";
import { getServicios } from "@/utils/requestServicios/getServicios";

interface InputContainerProps {
  data?: {
    añosSector: any;
    descripcion: any;
    id: any;
    precio: any;
    prestador: {
      apellidoCompleto: any;
      calificacion: any;
      descripcion: any;
      direccion: any;
      id: any;
      nombreCompleto: any;
      numeroTelefonico: any;
      username: any;
      zona: any;
    };
    rubro: any;
  };
}
export const DetalleServicio: React.FC<InputContainerProps> = ({ data }) => {
  const dispatch = useAppDispatch();
  const icono = profesiones.find(
    (profesion) => profesion.label === data?.rubro
  );
  console.log(data);

  return (
    <section className="max-w-max-view w-full gap-2">
      <button
        onClick={() => {
          dispatch(verServicios(""));
        }}
      >{`<- volver`}</button>

      <div className="flex flex-col">
        <div className="w-full h-[250px]">
          <Image
            alt="banner_perfil"
            src={"/images/Rectangle 8.png"}
            width={1500}
            height={150}
          />
        </div>
        <div className="w-fit ml-20 mt-15">
          <Image
            alt="perfil_img"
            src={"/images/Ellipse 48.png"}
            width={200}
            height={200}
          />
        </div>

        <section className="flex justify-between items-center">
          <div className="flex flex-col items-left mt-6 ml-20 gap-3 p-1">
            <span className="flex gap-2 text-light-orange text-xl">
              <BsStarFill />
              <BsStarFill />
              <BsStar />
            </span>
            <div>
              <h1 className="font-bold text-3xl">{data?.nombreCompleto}</h1>
              <p className="flex gap-3 p-1 mt-2 text-light-orange text-lg font-semibold">
                {data?.rubro}
                {icono ? <icono.icon className="h-8 w-8" /> : <></>}
              </p>
            </div>
          </div>

          <div className="font-semibold text-lg m-5">
            <button className="bg-green-600 text-white py-2 px-3 rounded-md hover:bg-green-700">
              <Ticket data={data} />
            </button>
          </div>
        </section>

        <div className="flex flex-col w-11/12 mt-6 ml-20 gap-2 text-lg text-trueGray-700">
          <div>
            <p className=""> {data?.descripcion}</p>
          </div>

          <div className="flex gap-6 mt-8 align-middle">
            <>
              <div className="float-left w-fit">
                {/* {icon ? <icon.icon className="w-[200px] h-[250px]" /> : <></>} */}
                <Image
                  alt="icono_electricista"
                  src="/images/iconamoon_lightning-2-fill.png"
                  width={200}
                  height={250}
                />
              </div>

              <div className="flex flex-col gap-2">
                <h1 className="font-bold text-3xl text-light-orange">
                  {data?.añosSector}
                </h1>
                <div className="flex flex-col gap-2 mt-4">
                  <p>{data?.descripcion}</p>
                </div>
              </div>
            </>
          </div>
        </div>

        <section className="flex flex-col w-fit mt-10 ml-20">
          <h2 className="text-4xl font-semibold mb-8">Certificados</h2>
          <div className="flex flex-row gap-4 p-2">
            <CertificadoCargado /> <CertificadoCargado /> <CertificadoCargado />
            <CertificadoCargado />
          </div>
        </section>

        <section>
          <div className="flex flex-col mt-12 items-center gap-4">
            <h2 className="text-4xl font-semibold">Reseñas</h2>
            <ReseñaPrestador />
          </div>
        </section>
      </div>
    </section>
  );
};

export default DetalleServicio;
