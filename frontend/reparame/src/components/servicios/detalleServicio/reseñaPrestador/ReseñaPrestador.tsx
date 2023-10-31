import Image from "next/image";
import { useState } from "react";
import { BsStarFill } from "react-icons/bs";
import { BsStar } from "react-icons/bs";

const ReseñaCard = () => {
  return (
    <figure className="relative flex flex-col-reverse border-4 border-light-orange rounded-lg p-6 shadow-md">
      <blockquote className="mt-6 text-gray-700">
        <p>
          {" "}
          Lo que más me impresionó fue la calidad del resultado final. El
          servicio cumplió con precisión todas mis necesidades y expectativas.
          ¡Muchas gracias!
        </p>
      </blockquote>
      <figcaption className="flex flex-row items-center space-x-4">
        <div className="text-base text-gray-900 font-bold flex text-center items-center gap-1">
          <Image
            className="flex-none w-12 h-12 rounded-full object-cover"
            src="/images/image-60.png"
            alt="usuario_profile"
            width={100}
            height={100}
          />
          <span>Nombre</span>
          <div className="flex gap-1 ml-2 text-light-orange py-2">
            <BsStarFill />
            <BsStarFill />
            <BsStarFill />
            <BsStar />
            <BsStar />
          </div>
        </div>
      </figcaption>
    </figure>
  );
};

const ReseñaPrestador = () => {
  const [showAll, setShowAll] = useState(false);
  const [ReseñasToShow, setReseñasToShow] = useState(3);

  const handleReseñasShowAll = () => {
    setShowAll(!showAll);
    if (showAll) {
      setReseñasToShow(3);
    } else {
      setReseñasToShow(ReseñasToShow + 6);
    }
  };

  return (
    <section className="relative max-w-max-view w-full mx-auto">
      <div className="flex-1 max-w-full mx-auto p-10">
        <ul className="grid grid-cols-1 gap-5 sm:grid-cols-2 md:gap-8 lg:grid-cols-3 lg:gap-5">
          {[...Array(ReseñasToShow)].map((_, index) => (
            <li key={index}>
              <ReseñaCard />
            </li>
          ))}
        </ul>
      </div>
      <div className="inset-x-0 bottom-0 flex justify-center bg-gradient-to-t from-dark-orange pt-32 pb-8  dark:from-slate-900 absolute">
        <button
          className="relative bg-slate-50 hover:bg-slate-100 text-sm text-dark-orange font-medium px-6 py-2 rounded-md flex items-center"
          onClick={handleReseñasShowAll}
        >
          {showAll ? "Ver menos" : "Ver todas"}
        </button>
      </div>
    </section>
  );
};

export default ReseñaPrestador;
