"use client"
import React from "react";
import Image from "next/image";
import logo from "../../../public/logo.png";
import Link from "next/link";
import click from "../../../public/click.svg";
import sobrereparame from "../../../public/images/sobrereparame.svg";
import mapaarg from "../../../public/images/mapaargentina.svg";
import fotoperfil from "../../../public/fotoperfilreseña.svg";
import orangestar from "../../../public/orangestar.svg";
import whitestar from "../../../public/whitestar.svg";
import tablet from "../../../public/images/tablet.svg";
import facebook from "../../../public/facebook.svg";
import twitter from "../../../public/twitter.svg";
import instagram from "../../../public/instagram.svg";
import HeaderManager from "../headerManager/HeaderManager";
import { profesiones } from "@/utils/profesiones";

const LandingPage = () => {
    return (
        <section className="max-w-max-view w-full">
            <HeaderManager page="home" />
            <section
                style={{
                    backgroundImage:
                        'url("/images/Part of male construction worker.svg")',
                }}
                className="w-full h-80 flex flex-col place-content-center place-items-center pt-36"
            >
                <h1 className="text-[#FFF] text-4xl font-extrabold">
                    ENCONTRA LA SOLUCIÓN A TU PROBLEMA EN UN CLICK
                </h1>
                <Image src={click} alt="" width={42.3} height={46.5} />
            </section>

            <section className="py-20 flex gap-5 place-content-center">
                {profesiones.map((profesion, index) => (
                    <div
                        key={index}
                        style={{
                            borderRadius: "15px",
                            border: "2px solid var(--2, #FF983F)",
                            background: "var(--6, #FFF)",
                            boxShadow: "0px 0px 3px 1px #FF983F",
                        }}
                        className="w-40 h-36 flex flex-col place-content-center place-items-center"
                    >
                        <Link href="/routes/servicios">
                            <profesion.icon   style={{
                                    width: "65.5px",
                                    height: "71.3px",
                                    color:"#FF983F"
                                }}
                            />
                        </Link>
                        <p className="text-[#FF983F] text-2xl font-light">
                            {profesion.label}
                        </p>
                    </div>
                ))}

                
            </section>

            <section className="w-full flex my-10">
                <div className="w-1/2 flex place-content-center place-items-center">
                    <Image src={sobrereparame} alt="" width={613} height={408} />
                </div>
                <div className="w-1/2 flex flex-col gap-5 place-content-center px-20">
                    <h2 className="text-4xl font-semibold">Sobre Reparame</h2>
                    <p className="text-xl font-light">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
                        repellat dicta maxime architecto similique nam! Accusamus voluptate
                        autem maxime aliquam corrupti beatae quia! Facere adipisci quasi
                        repellendus! Mollitia, maiores tempora.
                    </p>
                </div>
            </section>

            <section className="w-full flex my-32">
                <div className="w-1/2 flex flex-col gap-5 place-content-center px-20">
                    <h2 className="text-4xl font-semibold">
                        Encontranos en distintos <br /> puntos del pais
                    </h2>
                    <p className="text-xl font-light">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
                        repellat dicta maxime architecto similique nam! Accusamus voluptate
                        autem maxime aliquam corrupti beatae quia! Facere adipisci quasi
                        repellendus! Mollitia, maiores tempora.
                    </p>
                </div>

                <div className="w-1/2 flex place-content-center place-items-center">
                    <div
                        style={{
                            width: "539px",
                            height: "408px",
                            borderRadius: "15px",
                            opacity: "",
                        }}
                        className="bg-mega-light-orange flex place-content-center place-items-center"
                    >
                        <Image src={mapaarg} alt="" width={459} height={318} className="" />
                    </div>
                </div>
            </section>

            <section className="w-full flex flex-col my-20">
                <h2 className="text-center text-4xl font-semibold mb-14">
                    La experiencia de nuestros usuarios
                </h2>
                <div
                    id="cardsContainer"
                    className="flex gap-5 place-content-center place-items-center"
                >
                    <div
                        id="card"
                        className="flex flex-col place-content-center p-5 gap-4"
                        style={{
                            width: "451px",
                            height: "202px",
                            borderRadius: "15px",
                            border: "2px solid var(--2, #FF983F)",
                            background: "var(--6, #FFF)",
                            boxShadow: "0px 0px 3px 1px #FF983F",
                        }}
                    >
                        <div className="flex  gap-3">
                            <Image src={fotoperfil} alt="" width={37} height={37} />
                            <p className="text-[#1D1F21] text-2xl font-semibold ">Jorge</p>
                            <div className="flex  gap-2">
                                <Image src={orangestar} alt="" width={18.295} height={18.295} />
                                <Image src={orangestar} alt="" width={18.295} height={18.295} />
                                <Image src={orangestar} alt="" width={18.295} height={18.295} />
                                <Image src={orangestar} alt="" width={18.295} height={18.295} />
                                <Image src={whitestar} alt="" width={18.295} height={18.295} />
                            </div>
                        </div>
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit.
                            Cupiditate, eligendi alias nam labore quae eaque molestiae optio
                            voluptatum eos in facilis vel temporibus neque.
                        </p>
                    </div>

                    <div
                        id="card"
                        className="flex flex-col place-content-center p-5 gap-4"
                        style={{
                            width: "451px",
                            height: "202px",
                            borderRadius: "15px",
                            border: "2px solid var(--2, #FF983F)",
                            background: "var(--6, #FFF)",
                            boxShadow: "0px 0px 3px 1px #FF983F",
                        }}
                    >
                        <div className="flex  gap-3">
                            <Image src={fotoperfil} alt="" width={37} height={37} />
                            <p className="text-[#1D1F21] text-2xl font-semibold ">Jorge</p>
                            <div className="flex  gap-2">
                                <Image src={orangestar} alt="" width={18.295} height={18.295} />
                                <Image src={orangestar} alt="" width={18.295} height={18.295} />
                                <Image src={orangestar} alt="" width={18.295} height={18.295} />
                                <Image src={orangestar} alt="" width={18.295} height={18.295} />
                                <Image src={whitestar} alt="" width={18.295} height={18.295} />
                            </div>
                        </div>
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit.
                            Cupiditate, eligendi alias nam labore quae eaque molestiae optio
                            voluptatum eos in facilis vel temporibus neque.
                        </p>
                    </div>
                </div>
                <div className="text-end w-4/5 mt-2">
                    <Link
                        href=""
                        className="text-[#1D1F21] text-xl font-semibold underline"
                    >
                        Ver todas
                    </Link>
                </div>
            </section>

            <section className="w-full flex">
                <div className="w-1/2">
                    <Image src={tablet} alt="" width={790} height={807} />
                </div>
                <div className="w-1/2 flex flex-col gap-14 place-content-center place-items-center px-20">
                    <p className="text-4xl font-semibold">
                        ¿Eres un profesional de <br /> servicios para el hogar?
                    </p>
                    <Link
                        href=""
                        className="text-[#F5F5F5] bg-light-orange border border-black rounded-xl py-3 px-10"
                    >
                        Registrate
                    </Link>
                </div>
            </section>

            <footer className="w-full flex bg-light-orange h-36 text-center">
                <div className="flex flex-col place-content-start place-items-end gap-2 ml-24 mt-3">
                    <Image src={logo} alt="" width={168} height={44} />
                    <div className="flex gap-5">
                        <Image src={facebook} alt="" width={28} height={28} />
                        <Image src={twitter} alt="" width={28} height={28} />
                        <Image src={instagram} alt="" width={28} height={28} />
                    </div>
                </div>

                <div className="w-2/3 flex gap-6 place-content-center place-items-center mt-10">
                    <p className="text-white">Contactanos</p>
                    <p className="text-white"> | </p>
                    <p className="text-white">FQA</p>
                    <p className="text-white"> | </p>
                    <p className="text-white">Términos y condiciones</p>
                </div>
            </footer>
        </section>
    );
};

export default LandingPage;
