"use client";
import Swal from "sweetalert2";
import Image from "next/image";
import { useRef } from "react";
import StarsUser from "../icons/StarsUser";
import { Button } from "@nextui-org/react";
import { postTicket } from "@/utils/requestTicket/postTicket";
import { useState } from "react";
// import { setInterval } from 'timers/promises';
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
const Ticket: React.FC<InputContainerProps> = ({
  data
}) => {
  let f = new Date();
  let dia = f.getDate();
  let mes = f.getMonth();
  let anio = f.getFullYear();
  const [ticketData, setTicketData] = useState({
    fechaInicio: `${dia} - ${mes}-${anio}`,
    fechaRequerida: `${dia + 5} - ${mes}-${anio}`,
  });
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
      ? (postTicket("servicio.id", ticketData),
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
          className="flex flex-col gap-5 p-10"
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
            <div className="w-96">
              <figure className="flex flex-row  justify-between items-center">
                <div className="flex gap-4 items-center">
                  <Image
                    src="/images/Ellipse 48.png"
                    width={80}
                    height={80}
                    alt="imagen prueba"
                    className="rounded-full"
                  />
                </div>
                <div className="flex">
                  <p className="text-xl">
                    <b>{data ? data.prestador.nombreCompleto : {}}</b>
                  </p>
                  <p className="text-light-orange text-xl">
                    <b>{data ? data.prestador.apellidoCompleto : {}}</b>
                  </p>
                </div>
                <span className="text-lg text-light-orange">
                  <b>
                    <StarsUser />
                    {`${dia}/${mes}/${anio}`}
                  </b>
                </span>
              </figure>
              <p className="py-6">
                {data ? data.descripcion : {}}
              </p>
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
        className="bg-green-400 p-10 rounded-xl"
      >
        <span>Contratado con éxito!</span>
      </dialog>
    </div>
  );
};

export default Ticket;
