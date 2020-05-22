const path = require("path");
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const Dotenv = require("dotenv-webpack");

module.exports = {
    entry: './src/index.js',

    module: {
        rules: [
            {
                test: /\.(ts|tsx)$/,
                use: ['babel-loader', 'ts-loader'],
            },
            {
                test: /\.(js|jsx)$/,
                use: ['babel-loader'],
            },
            {
                test: /\.(jpg|png|svg)$/,
                loader: "file-loader",
                options: {
                    publicPath: "./",
                    name: "public/images/[name].[ext]?[hash]",
                },
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader'],
            },
        ],
    },

    resolve: {
        extensions: ['.js', '.jsx', '.ts', '.tsx'],
        alias: {
            'store': path.resolve(__dirname, "src/store/"),
            'utils': path.resolve(__dirname, "src/utils/"),
        }
    },

    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: 'public/index.html',
        }),
        new Dotenv({
            path: path.resolve(__dirname, "./.env.development"),
        }),
    ],
}