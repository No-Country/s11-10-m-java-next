import axios from "axios";

<<<<<<< HEAD
export const getServicios = async (setPrestadores: Function, servicioId: any, token: string, category: any) => {
    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    await axios.get(
        `https://reparame-api.onrender.com/servicios${servicioId ? '/' + servicioId : `?categoria=${category}`}`, {
        headers: { Authorization: `Bearer ${token}` }
    }
=======
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
>>>>>>> 6e16b75afa3fa393b3659321ea1fce27d2f2cf75
    )
    .then(function (response) {
      console.log(token);

      setPrestadores(response.data);
    })
    .catch(function (err) {
      localStorage.setItem("key", token);
      console.log("error");
      console.log(err);
    });
};
