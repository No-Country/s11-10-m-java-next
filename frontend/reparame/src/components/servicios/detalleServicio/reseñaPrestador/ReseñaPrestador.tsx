import Image from "next/image";
import { useState } from "react";
import { BsStarFill } from "react-icons/bs";
import { BsStar } from "react-icons/bs";
import reseñas from "@/utils/data/reseñas.json";

export type ReseñaProps = {
  description: string;
  user_name: string;
  calification: number;
};

const ReseñaCard = ({ description, user_name, calification }: ReseñaProps) => {
  return (
    <figure className="relative flex flex-col-reverse border-4 border-light-orange rounded-lg p-6 shadow-md">
      <blockquote className="mt-6 text-gray-700">
        <p>{description}</p>
      </blockquote>
      <figcaption className="flex flex-row items-center space-x-4">
        <div className="text-base text-gray-900 font-bold flex text-center items-center gap-1">
          <Image
            className="flex-none w-12 h-12 rounded-full object-cover"
            src="/images/3d-user.png"
            alt={user_name}
            width={100}
            height={100}
          />
          <span>{user_name}</span>
          <div className="flex gap-1 ml-2 text-light-orange py-2">
            {[...Array(Math.floor(calification))].map((_, index) => (
              <BsStarFill key={index} />
            ))}

            {[...Array(5 - Math.floor(calification))].map((_, index) => (
              <BsStar key={index} />
            ))}
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
          {reseñas.slice(0, ReseñasToShow).map((reseña, index) => (
            <li key={index}>
              <ReseñaCard
                description={reseña.description}
                user_name={reseña.user_name}
                calification={reseña.calification}
              />
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
