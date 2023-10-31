import { useAppDispatch } from "@/utils/globalStates/hooks";
import Image from "next/image";
import { BsStarFill } from "react-icons/bs";
import { BsStar } from "react-icons/bs";
import ReseñaPrestador from "../../reseñaPrestador/ReseñaPrestador";
import { verServicios } from "@/utils/globalStates/features/serviciosSlice";
import { profesiones } from "@/utils/profesiones";
import CertificadosSection from "./Certificado";

// const DetalleServicio = (servicio: any) => {
//     const dispatch = useAppDispatch()
//     const icon = profesiones.find(profesion => profesion.label == servicio.servicio.rubro);

const DetalleServicio = () => {
  const DetalleServicioData = [
    {
      id: 1,
      nombrePrestador: "Juan Perez",
      rubro: "Electricista",
      rubroIcon: "/images/iconamoon_lightning-2-fill.png",
      calificacion: "4/5",
      experiencia: "30 años",
      descripcionServicio:
        "Electricista técnico con casi 10 años de experiencia en la gestión e instalación de diferentes sistemas eléctricos, paneles, placas y todo tipo de circuitos. Mis conocimientos y experiencia han hecho siempre que destaque la profesionalidad por encima de cualquier cosa.",
      descripcionPersonal: [
        {
          subdescription:
            "• Mantenimiento, gestión y reporte de los distintos trabajos realizados por la empresas.",
        },
        {
          subdescription:
            "• Instalación y reparación de cableado en todo tipo de viviendas.",
        },
        { subdescription: "• Soporte 24 horas durante fines de semana." },
        { subdescription: "• Transporte de materiales." },
      ],
    },
  ];

  const dispatch = useAppDispatch();
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

        <div className="flex flex-col w-fit items-left mt-6 ml-20 gap-3 p-1">
          <span className="flex gap-2 text-light-orange text-xl">
            <BsStarFill />
            <BsStarFill />
            <BsStar />
            {/* {item.calificacion} */}
          </span>

          {DetalleServicioData.map((item, index) => (
            <div key={index}>
              <h1 className="font-bold text-3xl">{item.nombrePrestador}</h1>
              <p className="flex gap-3 p-1 mt-2 text-light-orange text-lg font-semibold">
                {/* {servicio.servicio.rubro}
                        {icon ? <icon.icon className='h-8 w-8' /> : <></>} */}
                {item.rubro}
                <Image
                  alt="icono_electricista"
                  src={item.rubroIcon}
                  width={30}
                  height={30}
                ></Image>
              </p>
            </div>
<<<<<<< HEAD
            <Ticket />
        </section>
    );
=======
          ))}
        </div>

        <div className="flex flex-col w-11/12 mt-6 ml-20 gap-2 text-lg text-trueGray-700">
          {DetalleServicioData.map((item, index) => (
            <div key={index}>
              <p className=""> {item.descripcionServicio}</p>
            </div>
          ))}

          <div className="flex gap-6 mt-8 align-middle">
            {DetalleServicioData.map((item, index) => (
              <>
                <div className="float-left w-fit">
                  <Image
                    alt="icono_electricista"
                    src={item.rubroIcon}
                    width={200}
                    height={250}
                  />
                </div>

                <div className="flex flex-col gap-2">
                  <h1 className="font-bold text-3xl text-light-orange">
                    {item.experiencia}
                  </h1>
                  <div className="flex flex-col gap-2 mt-4">
                    {item.descripcionPersonal.map((subitem, subindex) => (
                      <p key={subindex}>{subitem.subdescription}</p>
                    ))}
                  </div>
                </div>
              </>
            ))}
          </div>
        </div>

        <div className="flex flex-col w-fit mt-10 ml-20">
          <CertificadosSection />
        </div>

        <div className="flex flex-col mt-12 items-center gap-4">
          <h2 className="text-4xl font-semibold">Reseñas</h2>

          <ReseñaPrestador />
        </div>
      </div>
    </section>
  );
>>>>>>> af4a076966216666540fabbf749eb2aa7bda8fdd
};

export default DetalleServicio;
