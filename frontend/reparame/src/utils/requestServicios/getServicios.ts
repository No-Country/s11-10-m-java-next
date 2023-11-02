import axios from "axios";

export const getServicios = async (
  setPrestadores: Function,
  servicioId: any,
  token: string
) => {
  const config = {
    headers: { Authorization: `Bearer ${token}` },
  };

  await axios
    .get(
      `https://reparame-api.onrender.com/servicios${
        servicioId ? "/" + servicioId : ""
      }`,
      {
        headers: { Authorization: `Bearer ${token}` },
      }
    )
    .then(function (response) {
      setPrestadores(response.data);
    })
    .catch(function (err) {
      console.log("error");
      console.log(err);
    });
};
