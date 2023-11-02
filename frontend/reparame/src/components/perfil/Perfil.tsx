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
import { putUser } from "@/utils/requestUser/putUser";
import { useSession } from "next-auth/react";
const Perfil = () => {
  const { data: session } = useSession()
  const [userLog, setUserLog] = useState({
    id: "",
    nombreCompleto: "",
    apellidoCompleto: "",
    username: "",
    password: "",
    direccion: "",
    numeroTelefonico: "",
    provincia: "",
    cp: "",
    localidad: "",
    fechaNacimiento: "",
    zona: "",
    dni: "",
    rol: "",
    rubro: "",
    cuil: "",
  });
  const [postData, setPostData] = useState(
    {
      nombreCompleto: '',
      apellidoCompleto: '',
      username: '',
      direccion: '',
      numeroTelefonico: '',
      rubros: [userLog.rubro],
      dni: ''
    }
  );
  const [formData, setFormData] = useState({});
  useEffect(() => {
    setFormData(formData);
  }, [formData]);
  useEffect(() => {
    getUser(setUserLog, session?.user.accessToken);
  }, [session]);
  return (
    <section className="flex flex-col gap-10 max-w-max-textArea w-full px-10 pt-10 pb-10 text-light-orange bg-grayUi">
      <HeaderManager page="perfil" />
      <h1 className="text-2xl text-black">Configuración de perfil</h1>
      <figure className="flex flex-row items-center gap-6 flex-wrap">
        <div className="flex flex-row items-end">
          <Image
            src={"/images/Ellipse 48.png"}
            alt="avatar User"
            width={200}
            height={200}
            className="border-3 border-dark-orange rounded-full h-28 w-28"
          />
          <button className="bg-dark-orange rounded-full relative right-7 bottom-2">
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
          <InputsTextPerfil
            label="Email"
            placeholder={userLog.username}
            type="email"
            defaultValue={userLog.username}
            onChange={(e) => {
              setPostData({
                ...postData,
                username: e.target.value
              })
            }} />
          <InputsTextPerfil
            label="+54"
            placeholder={userLog.numeroTelefonico}
            type="number"
            defaultValue={userLog.numeroTelefonico}
            onChange={(e) => {
              setPostData({
                ...postData,
                numeroTelefonico: e.target.value
              })
            }} />
          <InputsTextPerfil
            label="Dirección"
            placeholder={userLog.direccion}
            type="number"
            defaultValue={userLog.direccion}
            onChange={(e) => {
              setPostData({
                ...postData,
                direccion: e.target.value
              })
            }} />
          <InputsTextPerfil
            label="CP"
            placeholder={'5000'}
            type="text"
            defaultValue={'5000'} />
          <InputsTextPerfil
            label="CUIL"
            placeholder={`2-${userLog.dni}-6`}
            type="number"
            defaultValue={userLog.dni} />
          <InputsTextPerfil
            label="DNI"
            placeholder={userLog.dni}
            type="number"
            defaultValue={userLog.dni}
            onChange={(e: any) => {
              setPostData({
                ...postData,
                dni: e.target.value
              })
            }} />
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
        <div className="flex justify-evenly gap-5 flex-wrap">
          <CardCertificados />
          <CardCertificados />
          <CardCertificados />
          <CardCertificados />
        </div>
      </section>

      <div className="border border-light-orange rounded-md p-5 w-44">
        <Link href={"/routes/historial"}>Acceder al historial</Link>
      </div>
      <button
        onClick={() => {
          postData.username &&
            postData.apellidoCompleto &&
            postData.direccion &&
            postData.dni &&
            postData.rubros &&
            postData.nombreCompleto &&
            postData.numeroTelefonico
            ? putUser(userLog.id, userLog.rol.toLowerCase(), postData, session?.user.accessToken) : {};
        }}
      >
        guardar
      </button>
      {/* <BtnsActualizar /> */}
    </section>
  );
};
export default Perfil;
