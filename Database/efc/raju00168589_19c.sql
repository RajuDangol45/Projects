-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2018 at 06:27 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `raju00168589_19c`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `id` int(11) NOT NULL,
  `questionId` int(11) NOT NULL,
  `answer` text NOT NULL,
  `answerer` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`id`, `questionId`, `answer`, `answerer`) VALUES
(1, 1, 'The available colors are black, red and white.', 'Raju'),
(2, 6, 'This car is very comfortable.', 'Raju'),
(3, 2, 'It has 4 wheels.', 'Raju'),
(4, 1, 'I think blue is also available.', 'Sophia'),
(5, 10, 'It has 6 wheels.', 'admin'),
(6, 14, 'No its less efficient compared to the others.', 'admin'),
(7, 16, 'Only black color is available in this model.', 'admin'),
(8, 8, 'This car is quite comfortable.', 'admin'),
(9, 13, 'Yes this car is quite efficient.', 'Raju'),
(10, 3, 'Its price start from 24000$.', 'Raju'),
(11, 18, 'It was released last year.', 'Raju'),
(12, 2, 'It has 4 wheels.', 'ben'),
(13, 18, 'Thank you', 'ben'),
(14, 9, 'It starts from $40,000.', 'ben'),
(15, 12, 'It is not as comfortable as the others.', 'ben'),
(16, 4, 'The name of the company is BMW.', 'ben'),
(17, 11, 'It is very comfortable.', 'ben'),
(18, 17, 'It has 6 wheels.', 'Sophia'),
(19, 15, 'No, it has been discontinued.', 'Sophia');

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `id` int(11) NOT NULL,
  `car_name` varchar(200) NOT NULL,
  `car_description` varchar(200) NOT NULL,
  `car_view_count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`id`, `car_name`, `car_description`, `car_view_count`) VALUES
(1, 'TOYOTA COROLLA HYBRID ', 'It may look bland, but the Toyota Corolla is one of Australiaâ€™s favourite cars for a reason â€“ itâ€™s a safe choice. Add a hybrid powertrain.', 52),
(2, 'TOYOTA PRIUS ', 'Toyotaâ€™s other hybrid hatch consumes even less than the Corolla, thanks to a slightly more modern hybrid powertrain and aero-optimised exterior. ', 100),
(3, 'NISSAN LEAF', 'Itâ€™s the cheapest pure-electric vehicle available in Australia, and totally worth a look-in if youâ€™re sticking to city runabouts.', 150),
(4, 'MITSUBISHI OUTLANDER PHEV', 'Itâ€™s a hybrid SUV, and anything this size that clocks a fuel efficiency figure under 5L/100km is a great option for anyone interested in keeping the greenhouse effect at bay. ', 200),
(5, 'AUDI A3 SPORTBACK e-TRON', 'The A3 plug-in may be conservative on the outside, but itâ€™s stunning on the inside with great technology and classy design. The 1.4-litre petrol-electric hybrid is the most fuel efficient option.', 250),
(6, 'BMW i3', 'The BMW i3 is offered as an EV or a plug-in hybrid, and recently underwent an update to extend its range to a possible 390km.', 300),
(7, 'TESLA MODEL S', 'The Tesla Model S offers the longest range in the EV space, with six variants available with varying battery capacities. Tesla added two models this year with the entry-level 60 and 60D.', 350),
(8, 'VOLVO XC90 ', 'Itâ€™s stylish, itâ€™s spacious and itâ€™s got seven seats. And, with the T8-spec petrol-electric hybrid engine and plug-in charging capability, itâ€™ll be the most fuel efficient', 400);

-- --------------------------------------------------------

--
-- Table structure for table `carsdescription`
--

CREATE TABLE `carsdescription` (
  `id` int(11) NOT NULL,
  `car_name` varchar(200) NOT NULL,
  `car_description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carsdescription`
--

INSERT INTO `carsdescription` (`id`, `car_name`, `car_description`) VALUES
(1, 'Toyota Corolla Hybrid', 'The Toyota Prius has become a synonym for environmentally-friendly motoring.\r\n<br />\r\nToyota has established its petrol-electric hybrid machine as the poster child for driving \'green\', with Hollywood celebrities ditching their luxury cars for the Japanese hatch.<br />A large part of its success is related to its looks. Toyota deliberately made the Prius stand-out in traffic, ensuring it not only justified its price premium over a similarly-sized non-hybrid but also helping owners tell the rest of the world they are \'doing their bit\' to save Mother Nature (and petrol).<br />But now Toyota is offering motorists the chance to enjoy the benefits of the Prius\' fuel-saving powertrain without the head-turning looks and pre-conceived image of being a \'tree-hugger\'.'),
(2, 'TOYOTA PRIUS ', 'In our tests the Prius returned 52 mpg overall, a significant improvement over the previous generation\'s 44 mpg. On top of that, the new car also handles more responsively and rides more comfortably. Colorful digital gauges dominate the dashboard with abundant fuel-economy information. The touch-screen infotainment system is fairly straightforward. The sensible Prius has always been about efficiency and low running costs. The car can drive solely on electric, up to about 25 mph typically, and the engine is now quieter when it kicks in. However, the seats are rather chintzy, tire noise is noticeable, and cabin access is not as easy because of the car\'s lower stance. A plug-in version, the Prius Prime, can go about 23 miles on electric power, and takes five hours to charge on 120V. Forward-collision warning with automatic braking is standard. <br />While the previous generation Prius was an evolution of the second-generation car it replaced, the fourth-generation Prius was a revolution. The biggest advance was an incredible 52 mpg overall, brought by a new, larger, and more efficient engine. Styling became much more controversial; its practical effect was that the Prius sits lower than before, sacrificing some access, visibility, and rear seat space. Still, this small hatchback can provide the family-hauling space of  most mid-sized sedans. Handling is more sure-footed and interior noise has been reduced. The interior doesn\'t feel as cheap as before, although some odd touches still remain, including some unconventional controls. 2017 brought standard forward collision warning and automatic emergency braking. <br />'),
(3, 'NISSAN LEAF ', 'Long before the Nissan Leaf, electric cars were significant players until the 1920s, and again in Japan in the late 1940s.\r\n\r\nBut it was with the invention of the lithium ion battery that Nissanâ€™s modern involvement began. In 1995 it launched the Prairie EV (and made 30), then the Altra EV (and made 200). It followed that with the compact Hypermini in 1999. The 2005 Pivo and Pivo2 concepts heralded the start of a development process that resulted in the Leaf.<br />The electric car has long been at the heart of the motoring industryâ€™s future-proof plans, but its evolution has not been an easy one so far. Held back by battery technology, electric cars have failed to be a viable proposition for the masses due to a high price and a severe compromise in usability. Nissan hoped to change that with the Leaf, a five-door hatchback that runs on a 107bhp electric motor.<br />The Leaf was originally introduced with retail prices starting from Â£30,000, though a government discount of Â£5000 helped, but that left a lot for Nissanâ€™s electric family car to prove. Shifting production from Japan to the UK in early 2013 reduced retail prices, as did the new pricing scheme, which allows buyers to lease the carâ€™s battery, with the pricing based on three different annual mileages.'),
(4, 'MITSUBISHI OUTLANDER PHEV', 'Dirty great SUVs might have had a poor eco reputation in the past, but Mitsubishi is hoping to alter that with the Outlander PHEV. As its name suggests, the Japanese SUV is available with a hi-tech plug-in hybrid system, making it the worldâ€™s greenest off-roader - now freshly facelifted.<br />The plug-in system is split into two parts â€“ a 2.0-litre petrol engine with 119bhp, plus twin electric motors (one on each axle) pushing out a total of 60bhp and 245lb ft. Either system can also be declutched and used to re-charge the batteries. Itâ€™s possible to run the Outlander on electric-only for up to 32.5 miles â€“ again, a theoretical figure â€“ and when the batteries are depleted, the petrol kicks in. Think of it like the Toyota Prius, only with more emphasis on electric-only driving and better mpg and CO2 figures (yes, really), and youâ€™re about there.'),
(5, 'AUDI A3 SPORTBACK e-TRON', 'A pleasing blend of hybrid and hatchback, the A3 e-tron gives you Audi cachet and power, plus an EPA-rated 83â€“86 MPGe. In fairness, in our test, we saw just 40 MPGe, but by most every performance measure the A3 e-tron still beats the BMW i3, the Chevrolet Volt, and the Ford C-Max Energi. A turbo four and a six-speed automatic team with an electric motor and battery. Electric-only range is rated at 16 miles. With 14 cubic feet of cargo space, this hatchback is roomy enough for everyday tasks. <br />It has been a decade since Al Gore hit the lecture circuit with his famed PowerPoint presentation/global-warming doomsday prophecy. In those 10 years, dozens of plug-in hybrids and electric vehicles have hit the market, promising ice-cap-friendly emissions and eliciting barely a glance from mainstream America (with one notable exception; hats off, Mr. Musk). Undeterred, Audi has a new entrant in this race that it hopes will be enough to tempt fuel-conscious customers who, in less scandalous times, might have shopped for a diesel from Germany. <br />That vehicle is the 2016 Audi A3 Sportback e-tron tested here. Itâ€™s among the first in what soon will become a herd of luxury or near-luxury plug-in hybridsâ€”look for the Mercedes-Benz C350e and the BMW 330e this year and several new Volvo PHEV models before the end of the decade. Compared with more familiar plug-ins such as the Chevrolet Volt and the Ford C-Max Energi, the Audi feels more upscale. Real leather seating surfaces come standard even on Audiâ€™s base Premium trim level, and the A3 boasts solid driving dynamics. Nor does the A3 shout its environmentalist credentials; it lacks the clichÃ© blue trim, and its charging-plug port is hidden behind the rings on the grille. One easily could mistake the e-tron for a regular A3. '),
(6, 'BMW i3', 'Unmistakable and unconventional, the i3 is a unique electric car. The funky hatchback has a carbon-fiber and aluminum structure with a standard 170-hp (i3) or a 184-hp (i3s) all-electric motor. All models offer an optional two-cylinder gas engine that extends the total EPA-rated range up to 180 miles. We saw 79 MPGe with the range-extended i3 and 111 MPGe with the pure EV version. The sporty i3s brings BMWâ€™s legendary driving dynamics to the lineup with a special suspension and larger wheels. <br />The BMW i3 is packed with clever engineering. Its carbon-fiber passenger cell rides on an aluminum skateboard chassis propelled by an electric motor powered by a lithium-ion battery that can get a range-extending boost from an optional two-cylinder engine. And yet none of that is so far outside the box as the social engineering baked into BMWâ€™s first electric car. The i3â€™s interior designers created a Zen-inspired cabin to lull drivers into a slower pace, in turn maximizing the batteryâ€™s range. That philosophy also helps explain why the tall and narrow runabout corners with all the eagerness of a phone booth. <br />As delightfully quirky and original as the i3 is, buyers have largely resisted its pulse-slowing charms. In the United States, BMW sells just a few hundred examples of the i3 every month, a convincing argument that few car buyers are seeking four-wheeled Zen. So four years into the i3â€™s existence, BMW is retrofitting some sportiness intoâ€”and an s badge ontoâ€”its electric car with the 2018 BMW i3s. This new model, set to land in dealerships alongside a facelifted i3 this month, promises quicker acceleration and livelier handling. <br />The i3s also rides on stiffer springs, dampers, and anti-roll bars, with the body lowered by 0.4 inch compared with the standard i3. The ride quality is well matched to modern roads, although the medieval stone-and-brick back alleys of Lisbon, Portugal, caused heads to wobble and bob. Corners are met with noticeably flatter body motions, but a parking-lot cone course set up by BMW proved the car is no more eager to turn in. Itâ€™s telling that the tight gymkhana kept speeds below 25 mph. The i3sâ€™s compact dimensions lend it a low-speed nimbleness but do nothing for high-speed stability. And even if theyâ€™re wider, the i3sâ€™s tires are the same low-rolling-resistance Bridgestone Ecopias as those used on the regular i3, and their relatively low limits mean hustling the i3s is still a pulse-calming affair. The i3s remains so disinterested in aggressive cornering that itâ€™s easy to forget this is a rear-wheel-drive car with a mid-mounted motor; an electric Porsche Cayman the BMW i3 is not. As an improvement over the i3, though, the i3s seems better positioned to replace the standard car than to merely complement it. '),
(7, 'TESLA MODEL S', 'Boasting up to 337 miles of range, the Model S is the all-electric dream car envied by many. Icing on the cake is Ludicrous mode, which blasts the top P100D to 60 mph in a claimed 2.5 seconds. The lower-spec models offer reduced driving ranges and features. Luxury items such as an air filter that Tesla says can protect occupants from bioweapons and pollutantsâ€”plus available high-tech features such as Teslaâ€™s Autopilotâ€”seal the deal. <br />The Tesla Model S has benefited from constant revisions throughout its life cycle, but its looks have stayed almost exactly the same since it was introduced in 2012. That finally changes with an update for the 2017 Model S that brings it in line with the recently revealed Model 3 sedan and the Model X crossover. Gone is the faux front grille, which is replaced by a new front fascia with slightly reshaped headlights and a sleeker, more streamlined look. <br />Tesla also claims increased driving range for the 90D and P90D models but doesnâ€™t cite any mechanical changes that account for the improved numbers. The 90D, with its 90-kWh battery, improves from 270 miles to 294 miles on a full charge, while the P90D sees range go from 253 miles to 270 miles. These numbers havenâ€™t yet been published on the EPAâ€™s website, although Teslaâ€™s own site says theyâ€™re EPA-official.<br />Another significant mechanical change is the newly standard 48-amp onboard charger that replaces the previous modelâ€™s 40-amp charger. Tesla says it enables quicker charging than before when connected to a 240-volt NEMA 14-50 power outlet or to a Tesla Wall Connector. We donâ€™t have exact numbers for the new charger, but the old 40-amp system was estimated to deliver 29 miles of range per hour of charge, so expect more than 30 miles per hour for the new car. This change wonâ€™t affect the amount of time it takes to juice up with Teslaâ€™s Supercharger network of quick chargers, and a $1500 upgrade that equips the car with a 72-amp charging system is available.<br />To go along with these changes, pricing for the 2017 Model S is up by $1500 across the range. The rear-wheel-drive 70 trim, with 234 miles of range, starts at $72,700, while opting for the all-wheel-drive 70D (with six extra miles of driving range) costs $5000 extra, as before. The Model S 90D, which has the highest range of any Tesla at 294 miles, costs $90,700, and the more powerful P90D tops the six-figure mark with its starting price of $110,700. '),
(8, 'VOLVO XC90 T8 INSCRIPTION AND T8 R-DESIGN', 'The XC90 is a handsome, square-jawed Swede striving to offer more efficiency and safety than its rivals while adding a dose of Scandinavian flair. Models marked T5 are powered by a 250-hp 2.0-liter turbo inline-four; T6 trims add a supercharger to the 2.0-liter for an increase to 316 hp. An 87-hp electric motor joins the party in T8 plug-in hybrid models. Thereâ€™s room for seven in the elegantly appointed interior, with deeply comfortable seats as well as Sensus, Volvoâ€™s infotainment system.<br /> As manufacturers introduce more and more SUVs and crossovers into the marketplace, itâ€™s becoming increasingly difficult for them to stand out. Some companies have attempted bold, polarizing exteriors, while others have dropped entries into previously unpopulated segments such as SUV â€œcoupesâ€ and the like, and many hope to attract buyers with advanced propulsion and technology solutions. But for the Volvo XC90, thereâ€™s no trick formula. The Swedes simply executed a traditional blueprint to its fullest potential. <br />The XC90 stunned onlookers when it debuted in 2014 and introduced the world to Volvoâ€™s new design language and upscale interior standards (although the vehicle didnâ€™t go on sale until a year later). Itâ€™s still beautiful and now is available with three different powertrains, including a plug-in hybrid, all of which are based on the same Drive-E four-cylinder engine. T5 models are set up with a 250-hp turbocharged inline-four; the T5 comes standard with front-wheel drive, and all-wheel drive is a $2200 option. The all-wheel-drive-only T6 models upgrade to a turbocharged and supercharged, 316-hp version of the four-cylinder. T8 models add electric power to the twincharged engine, creating an all-wheel-drive, 400-hp plug-in hybrid. Each variant is paired with an eight-speed automatic transmission. All XC90s come standard with seating for up to seven people, with one outlierâ€”the T8 can be ordered as a model called the XC90 Excellence, with two rows and four individual seats for a luxe-limo experience. <br />');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `question` text NOT NULL,
  `car_id` int(11) NOT NULL,
  `asker` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `question`, `car_id`, `asker`) VALUES
(1, 'What are the available colors?', 1, 'admin'),
(2, 'How many wheels does it have?', 3, 'admin'),
(3, 'What is its price?', 4, 'admin'),
(4, 'What is the name of the company?', 6, 'admin'),
(6, 'How comfortable is this car?', 2, 'admin'),
(8, 'How comfortable is this car?', 8, 'Raju'),
(9, 'What is the price range?', 5, 'Raju'),
(10, 'How many wheels does it have?', 1, 'Sophia'),
(11, 'How comfortable is this car?', 7, 'Sophia'),
(12, 'How comfortable is this car?', 5, 'Sophia'),
(13, 'Is this car efficient?', 2, 'Ben'),
(14, 'Is this car efficient?', 6, 'Ben'),
(15, 'Is it available now?', 7, 'Ben'),
(16, 'What are the available colors?', 8, 'Ben'),
(17, 'How many wheels does it have?', 8, 'Ben'),
(18, 'When was it released?', 4, 'Ben');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `dob` date NOT NULL,
  `postal_address` varchar(200) NOT NULL,
  `gender` varchar(200) NOT NULL,
  `user_type` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `email`, `dob`, `postal_address`, `gender`, `user_type`) VALUES
(1, 'Admin', 'Admin', 'Admin@gmail.com', '2000-01-01', '44600', 'Male', 'admin'),
(2, 'Raju', 'raju', 'raju@gmail.com', '1998-10-24', '44600', 'Male', 'normal'),
(3, 'Sophia', 'sophia', 'sophia@gmail.com', '1990-10-24', '44616', 'Female', 'normal'),
(4, 'Ben', 'ben', 'ben@gmail.com', '1995-01-05', '06987', 'Male', 'normal');

-- --------------------------------------------------------

--
-- Table structure for table `userage`
--

CREATE TABLE `userage` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userage`
--

INSERT INTO `userage` (`id`, `age`) VALUES
(1, 18),
(2, 20),
(3, 28),
(4, 23);

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`count`) VALUES
(20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `carsdescription`
--
ALTER TABLE `carsdescription`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userage`
--
ALTER TABLE `userage`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `carsdescription`
--
ALTER TABLE `carsdescription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
