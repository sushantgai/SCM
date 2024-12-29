console.log("Script loaded");

// Get initial theme from local storage
let currentTheme = getTheme();

// Change theme on page load
document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

// Function to handle theme changes
function changeTheme() {
  // Apply initial theme to the page
  changePageTheme(currentTheme, "");

  // Get the theme change button
  const changeThemeButton = document.querySelector("#theme_change_button");

  // Add click event listener to the button
  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;

    // Toggle between light and dark themes
    currentTheme = currentTheme === "dark" ? "light" : "dark";

    // Update the page theme and button text
    changePageTheme(currentTheme, oldTheme);
  });
}

// Set theme in local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

// Get theme from local storage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light"; // Default to light theme if not set
}

// Change the page theme
function changePageTheme(theme, oldTheme) {
  // Update theme in local storage
  setTheme(currentTheme);

  // Remove old theme class
  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }

  // Add new theme class
  document.querySelector("html").classList.add(theme);

  // Update button text
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}