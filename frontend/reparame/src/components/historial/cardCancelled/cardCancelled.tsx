import React from "react";
import Image from "next/image";
import { FaBolt } from "react-icons/fa";
import { Ticket } from "../Historial";

type CardProps = {
  ticket: Ticket;
};

// card trabajo cancelado
const CardCancelled: React.FC<CardProps> = ({ ticket }) => {
  return (
    <figure className="max-w-lg border-3 border-gray-700 rounded-lg p-6 shadow-md ">
      <figcaption className="flex flex-row items-center gap-2">
        <div className="flex justify-between gap-10">
          <p className="font-bold text-lg">
            Juan Perez - <span className="text-dark-orange">Córdoba</span>
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
          <span className="font-bold">Tarea:</span> Inspección eléctrica
          {/* {ticket.descripcion} */}
        </p>
        <div className="flex justify-between">
          <p className="text-dark-orange">
            <span className="font-bold text-gray-800">Estado:</span> Cancelado
            {/* {ticket.progreso} */}
          </p>
          <span className="text-slate-600 p-1 border-2 border-slate-600 rounded-md">
            <FaBolt />
            {/* {ticket.rubro} */}
          </span>
        </div>
      </blockquote>
    </figure>
  );
};

export default CardCancelled;
