"use client";
import Image from "next/image";
import { MdModeEdit } from "react-icons/md";
import { CardProfesiones } from "./cardProfesiones/CardProfesiones";
import { CardCertificados } from "./cardCertificados/CardCertificados";
import HeaderManager from "../headerManager/HeaderManager";
import CardDistance from "./cardDistance/CardDistance";
import CardExp from "./cardExp/CardExp";
import { useEffect, useState } from "react";
import { getUser } from "@/utils/requestUser/getUser";
import BtnsActualizar from "./btnsActualizar/BtnsActualizar";
import InputsTextPerfil from "./inputsTextPerfil/InputsTextPerfil";
import Link from "next/link";
const Perfil = () => {
  const [userLog, setUserLog] = useState({
    nombreCompleto: "ignacio",
    apellidoCompleto: "varela",
    email: "varelaig@gmail.com",
    password: "123",
    direccion: "Calle Falsa 123",
    numeroTelefonico: "155-96273549",
    provincia: "Santa Fe",
    cp: "500",
    localidad: "Rosario",
    fechaNacimiento: "2000-10-15",
    zona: "Centro",
    dni: "30156856",
    rol: "prestador",
    rubro: "GASISTA",
    cuil: "2-3446672-9",
  });
  const [formData, setFormData] = useState();
  useEffect(() => {
    setFormData(formData);
  }, [formData]);
  useEffect(() => {
    getUser(setUserLog);
  }, []);
  return (
    <section className="flex flex-col gap-10 max-w-max-textArea w-full px-10 pt-10 pb-10 text-light-orange bg-grayUi">
      <HeaderManager page="perfil" />
      <h1 className="text-2xl text-black">Configuración de perfil</h1>
      <figure className="flex flex-row items-center gap-6">
        <div className="flex flex-row items-end">
          <Image
            src={"/images/Ellipse 48.png"}
            alt="avatar User"
            width={120}
            height={120}
            className="border-3 border-dark-orange rounded-full"
          />
          <button className="bg-dark-orange rounded-full relative right-8 bottom-2">
            <MdModeEdit className="w-6 h-6 text-white p-1" />
          </button>
        </div>
        <figcaption className="text-2xl text-dark-orange">
          {userLog.nombreCompleto + " " + userLog.apellidoCompleto}
        </figcaption>
      </figure>
      <article className="flex flex-col gap-5 items-center">
        <textarea
          name=""
          placeholder="Descripción"
          className="text-grayText outline-none w-full p-5 h-52 shadow-cardsPerfil rounded resize-none"
        ></textarea>
        <div className="flex flex-row flex-wrap w-full justify-between gap-5">
          <CardDistance />
          <CardExp />
        </div>
        <div className="flex flex-wrap flex-row w-full justify-between items-center gap-5 ">
          <InputsTextPerfil data={userLog.email} label={"Email"} />
          <InputsTextPerfil data={userLog.numeroTelefonico} label={"+54"} />
          <InputsTextPerfil data={userLog.direccion} label={"Dirección"} />
          <InputsTextPerfil data={userLog.cp} label={"CP"} />
          <InputsTextPerfil data={userLog.cuil} label={"CUIL"} />
          <InputsTextPerfil data={userLog.dni} label={"DNI"} />
        </div>
      </article>
      <section>
        <h4 className="mb-5 text-dark-orange ">Tarifas</h4>
        <div className="flex md:flex-row flex-col gap-10 ">
          <label className="bg-white flex flex-row gap-5 p-5 w-48 shadow-cardsPerfil rounded ">
            Min $
            <input
              type="text"
              placeholder={"100"}
              className="w-20 text-grayText"
            />
          </label>
          <label className="bg-white flex flex-row gap-5 p-5 w-48 shadow-cardsPerfil rounded">
            Max $
            <input
              type="text"
              placeholder={"1500"}
              className="w-20 text-grayText"
            />
          </label>
        </div>
      </section>
      <section className="flex flex-col gap-5">
        <h3 className="text-dark-orange ">Profesiones</h3>
        <article className="flex flex-row gap-5">
          <CardProfesiones rubro={userLog.rubro} />
        </article>
      </section>
      <section className="flex flex-col gap-5">
        <h3 className="text-dark-orange ">Certificados</h3>
        <CardCertificados />
      </section>

      <div className="border border-light-orange rounded-md p-5">
        <Link href={"/routes/historial"}>Acceder al historial</Link>
      </div>

      <BtnsActualizar />
    </section>
  );
};
export default Perfil;
