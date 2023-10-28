import React from "react";
import Image from "next/image";

interface CertificadosProps {
  src: string;
  alt: string;
}

const Certificados: React.FC<CertificadosProps> = ({ src, alt }) => {
  return (
    <div className="cursor-pointer hover:scale-105 shadow-lg">
      <Image alt={alt} src={src} width={200} height={200} />
      {/* <Link></Link> */}
    </div>
  );
};

const CertificadosSection = () => {
  return (
    <>
      <h2 className="text-4xl font-semibold mb-8">Certificados</h2>
      <div className="flex flex-row gap-4 p-2">
        <Certificados src="/images/Frame 152.png" alt="certificados" />
        <Certificados src="/images/Frame 152.png" alt="certificados" />
        <Certificados src="/images/Frame 152.png" alt="certificados" />
        <Certificados src="/images/Frame 152.png" alt="certificados" />
      </div>
    </>
  );
};

export default CertificadosSection;
