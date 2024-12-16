import {UserModel} from '../models/User.js';
import bcrypt from 'bcrypt';

export const signUp = async (req, res) => {
    const { email, password } = req.body;
  
    try {
      const existingWorker = await UserModel.findOne({ email });
      if (existingWorker) {
        return res.status(400).json({ message: 'Email already registered' });
      }
      const hashedPassword = await bcrypt.hash(password, 10);
  
      
      const newWorker = new UserModel({
        email,
        password: hashedPassword
      });
  
      
      await newWorker.save();
      res.status(201).json({ message: 'Worker registered successfully!' });
  
    } catch (error) {
      console.error('Signup Error:', error);
      res.status(500).json({ message: error.message });
    }
};

export const login = async (req, res) => {
    const { email, password } = req.body;
  
    try {

      const worker = await UserModel.findOne({ email });
      if (!worker) {
        return res.status(404).json({ message: 'Worker not found' });
      }
  
      
      const isPasswordValid = await bcrypt.compare(password, worker.password);
      if (!isPasswordValid) {
        return res.status(400).json({ message: 'Incorrect password' });
      }
  
      res.status(200).json({
        message: 'Login successful',
        worker: {
          id: worker._id,
          email: worker.email,
          name: worker.name,
        }
      });
  
    } catch (error) {
      console.error('Signup Error:', error);
      res.status(500).json({ message: error.message });
    }
  };
  