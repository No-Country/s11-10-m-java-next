import { useAppDispatch } from '@/utils/globalStates/hooks'
import Ticket from '@/components/ticket/Ticket'
import Image from "next/image";
import { BsStarFill } from "react-icons/bs";
import { BsStar } from "react-icons/bs";
import ReseñaPrestador from "../../reseñaPrestador/ReseñaPrestador";
import { verServicios } from '@/utils/globalStates/features/serviciosSlice'
import { profesiones } from '@/utils/profesiones';

const DetalleServicio = (servicio: any) => {
    const dispatch = useAppDispatch()
    const icon = profesiones.find(profesion => profesion.label == servicio.servicio.rubro);

    return (
        <section className="max-w-max-view w-full gap-2">
            <button onClick={() => { dispatch(verServicios('')) }}>{`<- volver`}</button>
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
                        <BsStar />
                    </span>
                    <h1 className="font-bold text-3xl">Carlos Andres Parra Torre</h1>
                    <p className="flex gap-3 p-1 text-light-orange text-lg font-semibold">
                        {servicio.servicio.rubro}
                        {icon ? <icon.icon className='h-8 w-8' /> : <></>}
                    </p>
                </div>

                <div className="flex flex-col w-11/12 mt-6 ml-20 gap-2 text-lg text-trueGray-700">
                    <p className="">
                        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ullam eos
                        expedita accusantium omnis, itaque unde eaque obcaecati ut dolore
                        minus hic qua dicta libero magnam incidunt quibusdam numquam porro
                        animi? Lorem ipsum, dolor sit amet consectetur adipisicing elit.
                        Ullam eos expedita accusantium omnis, itaque unde eaque obcaecati ut
                        dolore minus hic qua dicta libero magnam incidunt quibusdam numquam
                        porro animi?
                    </p>

                    <div className="flex gap-6 mt-8 align-middle">
                        <div className="float-left w-fit">
                            <Image
                                alt="icono_electricista"
                                src={"/images/iconamoon_lightning-2-fill.png"}
                                width={300}
                                height={350}
                            />
                        </div>

                        <div className="flex flex-col gap-3">
                            <h1 className="font-bold text-3xl text-light-orange">30 Años</h1>
                            <p className="">
                                Lorem ipsum dolor sit, amet consectetur adipisicing elit. Illum,
                                beatae sunt quas et eum sit dicta vero optio tempore, laboriosam
                                esse nemo quibusdam rerum enim aspernon possimus doloremque?
                                Est, ipsa?beatae sunt quas et eum sit dicta vero optio tempore,
                                laboriosam esse nemo quibusdam rerum enim aspernon possimus
                                doloremque?
                            </p>
                        </div>
                    </div>
                </div>

                <div className="flex flex-col w-fit mt-10 ml-20">
                    <h2 className="text-4xl font-semibold mb-8">Certificados</h2>
                    <div className="flex flex-row gap-4 p-2">
                        <div className="cursor-pointer hover:scale-105 shadow-lg">
                            <Image
                                alt="certificados"
                                src={"/images/Frame 152.png"}
                                width={200}
                                height={200}
                            />
                            {/* <Link></Link> */}
                        </div>
                        <div className="cursor-pointer hover:scale-105 shadow-lg">
                            <Image
                                alt="certificados"
                                src={"/images/Frame 152.png"}
                                width={200}
                                height={200}
                            />
                            {/* <Link></Link> */}
                        </div>
                        <div className="cursor-pointer hover:scale-105 shadow-lg">
                            <Image
                                alt="certificados"
                                src={"/images/Frame 152.png"}
                                width={200}
                                height={200}
                            />
                            {/* <Link></Link> */}
                        </div>
                        <div className="cursor-pointer hover:scale-105 shadow-lg">
                            <Image
                                alt="certificados"
                                src={"/images/Frame 152.png"}
                                width={200}
                                height={200}
                            />
                            {/* <Link></Link> */}
                        </div>
                    </div>
                </div>

                <div className="flex flex-col mt-12 items-center gap-4">
                    <h2 className="text-4xl font-semibold">Reseñas</h2>

                    <ReseñaPrestador />
                </div>
            </div>
            {/* <Ticket /> */}
        </section>
    );
};

export default DetalleServicio;