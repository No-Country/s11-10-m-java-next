export function validateEmail(email: string): boolean {
    const expresionRegular: RegExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  
    return expresionRegular.test(email);
}
  

export function validatePassword(password: string): boolean {
    const expresionRegular: RegExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&+])[A-Za-z\d@$!%*?&+]{6,}$/;
        
    return expresionRegular.test(password);
  }