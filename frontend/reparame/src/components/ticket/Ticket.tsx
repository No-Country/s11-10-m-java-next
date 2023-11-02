"use client";
import Swal from "sweetalert2";
import Image from "next/image";
import { useRef } from "react";
import StarsUser from "../icons/StarsUser";
import { Button } from "@nextui-org/react";
import { postTicket } from "@/utils/requestTicket/postTicket";
import { useState } from "react";
import { useSession } from 'next-auth/react'
// import { setInterval } from 'timers/promises';
interface InputContainerProps {
  data?: {
    añosSector: any
    descripcion: any
    id: any
    precio: any
    nombrePrestador: any,
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
const Ticket: React.FC<InputContainerProps> = ({
  data
}) => {
  let f = new Date();
  let dia = f.getDate();
  let mes = f.getMonth();
  let anio = f.getFullYear();
  const { data: session } = useSession()

  const ticketRef = useRef<HTMLDialogElement>(null);
  const alertRef = useRef<HTMLDialogElement>(null);
  const openTicket = () => {
    ticketRef.current != null ? ticketRef.current.showModal() : {};
  };

  const closeTicket = () => {
    ticketRef.current != null ? ticketRef.current.close() : {};
  };
  const openAlert = () => {
    alertRef.current != null
      ? (postTicket(data?.id, session?.user.accessToken),
        alertRef.current.showModal(),
        setTimeout(() => {
          alertRef.current != null ? alertRef.current.close() : {};
        }, 2000))
      : {};
  };
  const closeAlert = () => {
    alertRef.current != null ? alertRef.current.close() : {};
  };
  return (
    <div>
      <dialog ref={ticketRef}>
        <form
          method="dialog"
          className="flex flex-col gap-5 p-10 "
          onSubmit={openAlert}
        >
          <section className="flex gap-5 w-full">
            <div className="flex gap-2">
              <Image
                src={"/oficina1.jpg"}
                width={50}
                height={200}
                alt="oficina1"
                className="w-40 h-full rounded-md"
              />
              <div className="flex flex-col gap-2">
                <Image
                  src={"/oficina2.jpg"}
                  width={50}
                  height={100}
                  alt="oficina1"
                  className="w-40 h-48 rounded-md"
                />
                <Image
                  src={"/oficina3.jpg"}
                  width={50}
                  height={100}
                  alt="oficina1"
                  className="w-40 h-48 rounded-md"
                />
              </div>
            </div>
            <div className="flex flex-col w-96 h-full justify-between">
              <figure className="flex flex-row  justify-between items-center">
                <div className="flex gap-4 items-center">
                  <Image
                    src="/images/Ellipse 48.png"
                    width={80}
                    height={80}
                    alt="imagen prueba"
                    className="rounded-full"
                  />
                  <figcaption>{data?.nombrePrestador || data?.prestador.nombreCompleto && data?.prestador.apellidoCompleto}</figcaption>
                </div>
                <div className="flex">
                  {/* <p className="text-xl">
                    <b>{data ? data.nombreCompleto : {}}</b>
                  </p>
                  <p className="text-light-orange text-xl">
                    <b>{data ? data.apellidoCompleto : {}}</b>
                  </p> */}
                </div>
                <span className="text-lg text-light-orange">
                  <b>
                    <StarsUser />
                    {`${dia}/${mes}/${anio}`}
                  </b>
                </span>
              </figure>
              <span className="py-6">
                {data?.descripcion}
              </span>
              <span className="py-6">
                $ {data?.precio}
              </span>
              <menu className="flex flex-row gap-10 self-center">
                <Button
                  className="w-36 text-white hover:bg-red2 bg-red"
                  id="cancel"
                  type="reset"
                  onClick={closeTicket}
                >
                  Cancel
                </Button>
                <Button
                  className="w-36 text-white hover:bg-light-orange bg-orange"
                  type="submit"
                >
                  Confirm
                </Button>
              </menu>
            </div>
          </section>
        </form>
      </dialog>
      <menu>
        <button onClick={openTicket}>Contratar</button>
      </menu>
      <dialog
        onClick={closeAlert}
        ref={alertRef}
        className="bg-green-400 p-10 rounded-xl text-center justify-center items-center"
      >
        <div className="flex items-center justify-center mb-2">
          {" "}
          <Image src="/images/Capa_1.png" alt="logo" width={150} height={150} />
        </div>

        <span>¡Ticket enviado!</span>
        <p>El prestador se comunicará contigo a la brevedad</p>
      </dialog>
    </div>
  );
};

export default Ticket;
