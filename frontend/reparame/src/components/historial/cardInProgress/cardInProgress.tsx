import React from "react";
import Image from "next/image";
import { FaBolt } from "react-icons/fa";
import { Ticket } from "../Historial";

type CardProps = {
  ticket: Ticket;
};

// card trabajo tomado en progreso
const CardinProgress: React.FC<CardProps> = ({ ticket }) => {
  return (
    <figure className="max-w-lg border-3 border-green-600 rounded-lg p-6 shadow-md">
      <figcaption className="flex flex-row items-center gap-2">
        <Image
          alt="usuario_profile"
          src="/images/image-60.png" // si me lo mandan de la api {ticket.profileImage}
          width={50}
          height={50}
        />

        <div className="flex justify-between gap-10">
          <p className="font-bold text-lg">
            Lucas Gomez - <span className="text-dark-orange">Córdoba</span>
            {/* {`${ticket.nombrePrestador} - ${ticket.zona}`} */}
          </p>
          <p className="text-dark-orange font-bold text-lg">
            26/10/2023
            {/* {ticket.fechaInicio} */}
          </p>
        </div>
      </figcaption>

      <blockquote className="mt-6 text-gray-800 flex flex-col gap-3 text-lg">
        <p>
          <span className="font-bold">Tarea:</span> Cambio de cables
          {/* {ticket.descripcion} */}
        </p>
        <div className="flex justify-between">
          <p>
            <span className="font-bold text-gray-800">Estado:</span> Trabajo
            finalizado
            {/* {ticket.progreso} */}
          </p>
          <span className="text-light-orange p-1 border-2 border-light-orange rounded-md">
            <FaBolt />
            {/* {ticket.rubro} */}
          </span>
        </div>
      </blockquote>
    </figure>
  );
};

export default CardinProgress;
