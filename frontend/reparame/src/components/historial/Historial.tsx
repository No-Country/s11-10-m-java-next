import React from "react";
import Ticket from "../ticket/Ticket";
import HeaderManager from "../headerManager/HeaderManager";
import Image from "next/image";
import { FaBolt } from "react-icons/fa";

// card trabajo tomado y terminado
const CardDone = () => {
  return (
    <figure className="max-w-lg border-3 border-light-orange rounded-lg p-6 shadow-md">
      <figcaption className="flex flex-row items-center gap-2">
        <Image
          alt="usuario_profile"
          src="/images/image-60.png"
          width={50}
          height={50}
        />

        <div className="flex justify-between gap-10">
          <p className="font-bold text-lg">
            Juan Perez - <span className="text-dark-orange">Córdoba</span>
          </p>
          <p className="text-dark-orange font-bold text-lg">18/10/2023</p>
        </div>
      </figcaption>

      <blockquote className="mt-6 text-gray-800 flex flex-col gap-3 text-lg">
        <p>Tarea: Reparación de XXXXXXX</p>
        <div className="flex justify-between">
          <p>Estado: TRABAJO FINALIZADO</p>
          <span className="text-light-orange p-1 border border-light-orange rounded-sm">
            <FaBolt />
          </span>
        </div>
      </blockquote>
    </figure>
  );
};

// card trabajo tomado en progreso
const CardinProgress = () => {
  return (
    <figure className="max-w-lg border-3 border-lime-400 rounded-lg p-6 shadow-md">
      <figcaption className="flex flex-row items-center gap-2">
        <Image
          alt="usuario_profile"
          src="/images/image-60.png"
          width={50}
          height={50}
        />

        <div className="flex justify-between gap-10">
          <p className="font-bold text-lg">
            Lucas Gomez - <span className="text-lime-500">Córdoba</span>
          </p>
          <p className="text-lime-500 font-bold text-lg">26/10/2023</p>
        </div>
      </figcaption>

      <blockquote className="mt-6 text-gray-800 flex flex-col gap-3 text-lg">
        <p>Tarea: Reparación de XXXXXXX</p>
        <div className="flex justify-between">
          <p>Estado: TRABAJO EN PROGRESO</p>
          <span className="text-light-orange p-1 border border-light-orange rounded-sm">
            <FaBolt />
          </span>
        </div>
      </blockquote>
    </figure>
  );
};

// card trabajo cancelado
const CardCancelled = () => {
  return (
    <figure className="max-w-lg border-3 border-slate-300 rounded-lg p-6 shadow-md bg-gray-300">
      <figcaption className="flex flex-row items-center gap-2">
        <Image
          alt="usuario_profile"
          src="/images/image-60.png"
          width={50}
          height={50}
        />

        <div className="flex justify-between gap-10">
          <p className="font-bold text-lg">
            Juan Perez - <span className="text-slate-600">Córdoba</span>
          </p>
          <p className="text-slate-600 font-bold text-lg">26/10/2023</p>
        </div>
      </figcaption>

      <blockquote className="mt-6 text-gray-800 flex flex-col gap-3 text-lg">
        <p>Tarea: Reparación de XXXXXXX</p>
        <div className="flex justify-between">
          <p>Estado: TRABAJO CANCELADO</p>
          <span className="text-slate-600 p-1 border border-slate-600 rounded-sm">
            <FaBolt />
          </span>
        </div>
      </blockquote>
    </figure>
  );
};

const Historial = () => {
  return (
    <section className="max-w-max-view w-full">
      <HeaderManager page="historial" />
      {/* <Ticket /> */}
      <h1 className="text-2xl">Historial</h1>
      <div className="flex flex-col justify-center content-center gap-5 p-3">
        <CardDone />
        <CardinProgress />
        <CardCancelled />
      </div>
    </section>
  );
};
export default Historial;
