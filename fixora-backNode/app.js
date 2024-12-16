import express from 'express';
import mongoose from 'mongoose';
//import cors from 'cors';
import userRouter from './routes/userRouter.js';
import eurekaClient from '../fixora-backNode/eureka-client.js';

const app = express();
const PORT = process.env.PORT || 3000;
const MONGO_URI = 'mongodb://localhost:27017/Fixora';

app.use(express.json());
//app.use(cors());
app.use('/auth', userRouter); 

mongoose.connect(MONGO_URI)
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('Failed to connect to MongoDB:', err));

app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});

export default app;
