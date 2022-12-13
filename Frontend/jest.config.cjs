module.exports = {
    moduleNameMapper: {
        '\\.(css|less)$' : 'identity-obj-proxy'
    },
    testEnvironment: 'jsdom',
    roots: [
        "<rootDir>/src"
    ]
}