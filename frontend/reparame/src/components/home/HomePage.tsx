"use client"
import React from "react";
import Image from "next/image";
import logo from "../../../public/logo.png";
import Link from "next/link";
import click from "../../../public/click.svg";
import sobrereparame from "../../../public/images/sobrereparame.svg";
import mapaarg from "../../../public/images/mapaargentina.svg";

import facebook from "../../../public/facebook.svg";
import twitter from "../../../public/twitter.svg";
import instagram from "../../../public/instagram.svg";

import Premium from "../../../public/Premium.svg";
import HeaderManager from "../headerManager/HeaderManager";
import { profesiones } from "@/utils/profesiones";
import { BiSearchAlt } from 'react-icons/bi'
import { GiShakingHands } from 'react-icons/gi'
import { PiChatCenteredDots } from 'react-icons/pi'

function HomePage() {
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

                        className="w-40 h-36 shadow-cardProfesionHome flex flex-col place-content-center place-items-center bg-white rounded-xl hover:bg-light-orange text-light-orange hover:text-white"
                    >
                        <Link href={`/routes/servicios?categoria=${profesion.label}`}>
                            <profesion.icon className="" style={{
                                width: "65.5px",
                                height: "71.3px"

                            }}
                            />
                        </Link>
                        <p className=" text-2xl font-light text-center">
                            {profesion.label}
                        </p>
                    </div>
                ))}


            </section>

            <section className="w-full flex mt-10 mb-20 flex-col text-center">
                <h2 className="font-semibold text-3xl mb-16">La solucion que buscas, en tres pasos:</h2>
                <div className="flex justify-center gap-40">

                    <div className="text-center flex flex-col gap-4">
                        <figure className="flex items-center">
                            <span className="bg-light-orange shadow-spanCircle px-4 py-1 rounded-full relative left-6 text-white text-4xl font-extrabold">1</span>
                            <div className="bg-white shadow-circle w-60 h-60 rounded-full flex items-center justify-center">
                                <BiSearchAlt className="w-32 h-32 text-light-orange" />
                            </div>

                        </figure>
                        <p className="pl-5 text-3xl font-medium">Buscá el <br /> servicio</p>
                    </div>

                    <div className="text-center flex flex-col gap-4">
                        <figure className="flex items-center">
                            <span className="bg-light-orange shadow-spanCircle px-3 py-1 rounded-full relative left-6 text-white text-4xl font-extrabold">2</span>
                            <div className="bg-white shadow-circle w-60 h-60 rounded-full flex items-center justify-center">
                                <PiChatCenteredDots className="w-32 h-32 text-light-orange" />
                            </div>

                        </figure>
                        <p className="pl-5 text-3xl font-medium">Contactá al <br /> profesional</p>
                    </div>

                    <div className="text-center flex flex-col gap-4">
                        <figure className="flex items-center">
                            <span className="bg-light-orange shadow-spanCircle px-3 py-1 rounded-full relative left-6 text-white text-4xl font-extrabold">3</span>
                            <div className="bg-white shadow-circle w-60 h-60 rounded-full flex items-center justify-center">
                                <GiShakingHands className="w-32 h-32 text-light-orange" />
                            </div>

                        </figure>
                        <p className="pl-5 text-3xl font-medium">Contratalo</p>
                    </div>


                </div>
            </section>

            <section className="w-full bg-mega-light-orange py-16">
                <p className="text-center font-semibold text-4xl mb-10">¿Queres tener más alcance? Convertite en PREMIUM</p>
                <div className="flex justify-center mr-32 gap-20">
                    <div>
                        <Image src={Premium} alt="" width={116} height={150} />
                    </div>
                    <div className=" flex flex-col justify-center items-center text-center gap-7">
                        <p className=" text-xl font-medium">Hacete Premium por solo $999,- pesos al mes y <br /> aprovechá todos los beneficios que tenemos para vos</p>
                        <ul className="flex flex-col gap-1 list-disc mb-10  text-xl font-medium">
                            <li>Contactos ilimitados con los profesionales</li>
                            <li>Descuentos exclusivos y promociones destacadas</li>
                        </ul>

                    </div>

                </div>

                <div className="flex place-content-center">
                    <Link href="" className="text-[#F60] bg-[#F5F5F5] text-2xl px-10 py-3">contactanos</Link>
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
    )
}

export default HomePage