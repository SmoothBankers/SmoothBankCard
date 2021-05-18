import { render, screen } from '@testing-library/react';
import App from '../src/App';

test('renders home page', () => {
  render(<App />);
  const homeElement = screen.getByText(/Welcome/);
  expect(homeElement).toBeInTheDocument();
});

