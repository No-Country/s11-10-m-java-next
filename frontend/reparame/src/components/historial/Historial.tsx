"use client";

import React, { useEffect, useState } from "react";
import Ticket from "../ticket/Ticket";
import HeaderManager from "../headerManager/HeaderManager";
import { getTickets } from "@/utils/requestTicket/getTickets";
import CardDone from "./cardDone/cardDone";
import CardCancelled from "./cardCancelled/cardCancelled";
import CardinProgress from "./cardInProgress/cardInProgress";

export type Ticket = {
  id: number;
  estado: boolean;
  descripcion: string;
  fechaInicio: string;
  fechaRequerida: string;
  progreso: string;
  nombrePrestador: string;
  zona: string;
  rubro: string;
};

const Historial = () => {
  const [tickets, setTickets] = useState<Ticket[]>([]);

  useEffect(() => {
    getTickets((data: Ticket[]) => {
      setTickets(data);
    });
  }, []);

  return (
    <section className="max-w-max-view w-full">
      <HeaderManager page="historial" />
      <h1 className="text-3xl font-bold text-gray-700 p-4">Historial</h1>
      <div className="flex flex-col justify-center content-center gap-5 p-3">
        {tickets.map((ticket) => {
          if (ticket.progreso === "CANCELADO") {
            return <CardCancelled key={ticket.id} ticket={ticket} />;
          } else if (
            ticket.progreso === "SOLICITADO" ||
            ticket.progreso === "EN_PROGRESO"
          ) {
            return <CardinProgress key={ticket.id} ticket={ticket} />;
          } else if (ticket.progreso === "FINALIZADO") {
            return <CardDone key={ticket.id} ticket={ticket} />;
          }
        })}
      </div>
    </section>
  );
};

export default Historial;
