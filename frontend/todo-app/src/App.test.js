import {render, screen} from '@testing-library/react';


import App from "./components/learning-example/Component4";

test('renders learn react link', () => {
    render(<App/>);
    const linkElement = screen.getByText(/learn react/i);
    expect(linkElement).toBeInTheDocument();
});