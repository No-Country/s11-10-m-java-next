"use client";
import Image from "next/image";

export function CertificadoCargado() {
  return (
    <div className="cursor-pointer hover:scale-105 shadow-lg">
      <Image
        alt="certificado"
        src="/images/Frame 152.png"
        width={200}
        height={200}
      />
    </div>
  );
}
