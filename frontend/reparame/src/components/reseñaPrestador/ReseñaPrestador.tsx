import Image from "next/image";
import { BsStarFill } from "react-icons/bs";
import { BsStar } from "react-icons/bs";

const ReseñaCard = () => {
  return (
    <figure className="relative flex flex-col-reverse border-4 border-light-orange rounded-lg p-6 shadow-md">
      <blockquote className="mt-6 text-gray-700">
        <p> lorem ipsum lorem ipsum lorem ipsum</p>
      </blockquote>
      <figcaption className="flex flex-row items-center space-x-4">
        <div className="text-base text-gray-900 font-bold flex text-center items-center gap-1">
          <Image
            className="flex-none w-12 h-12 rounded-full object-cover"
            src="/images/3d-user.png"
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
  return (
    <section className="relative max-w-max-view w-full mx-auto">
      <div className="flex-1 max-w-full mx-auto p-10">
        <ul className="grid grid-cols-1 gap-5 sm:grid-cols-2 md:gap-8 lg:grid-cols-3 lg:gap-5">
          <li>
            <ReseñaCard />
          </li>
          <li>
            <ReseñaCard />
          </li>
          <li>
            <ReseñaCard />
          </li>
          <li>
            <ReseñaCard />
          </li>
          <li>
            <ReseñaCard />
          </li>
          <li>
            <ReseñaCard />
          </li>
          <li>
            <ReseñaCard />
          </li>
          <li>
            <ReseñaCard />
          </li>
          <li>
            <ReseñaCard />
          </li>
        </ul>
      </div>
      <div className="inset-x-0 bottom-0 flex justify-center bg-gradient-to-t from-dark-orange pt-32 pb-8  dark:from-slate-900 absolute">
        <button
          className="relative bg-slate-50 hover:bg-slate-100 text-sm text-dark-orange font-medium px-6 py-2 rounded-md flex items-center">
          Ver todas
        </button>
      </div>
    </section>
  );
};

export default ReseñaPrestador;