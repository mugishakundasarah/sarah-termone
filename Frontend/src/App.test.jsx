import React from "react";
import { render , screen} from "@testing-library/react";
import App from './App'
import Calculator from "./Calculator";

it('should find the corresponding component', () => {
    render(<App/>)
    expect(screen.getByText(/unsocial/i)).toBeDefined();
})

it('should the calculator component', () => {
    render(<Calculator/>)
    expect(screen.getByText(/Display Result/i)).toBeDefined();
})
