import { Cookies } from "react-cookie"

const cookies = new Cookies();

export const setCookie = (name, value, option) => {
  return cookies.set(name, value);
};
export const getCookie = (name) => {
  return cookies.set(name);
};
export const deleteCookie = (name) => {
  // cookie 삭제 시간 지정
  document.cookie = name + "=; expires=Thu, 01 jan 1970 00:00:01 GMT;";
}